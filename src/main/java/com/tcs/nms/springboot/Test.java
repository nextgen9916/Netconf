package com.tcs.nms.springboot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.tailf.jnc.Attribute;
import com.tailf.jnc.Device;
import com.tailf.jnc.DeviceUser;
import com.tailf.jnc.Element;
import com.tailf.jnc.ElementChildrenIterator;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.NetconfSession;
import com.tailf.jnc.NodeSet;
import com.tailf.jnc.YangElement;

import gen.com.example.test.hosts.Hosts;
import gen.com.example.test.hosts.Simple;
import gen.com.example.test.hosts.hosts.Host;
import gen.com.example.test.simplelist.Simplelist;

public class Test {

    public Test(String ipaddress1) {
		ipaddress = ipaddress1;
        init();
    }

   public Test() {
        init();
    }

    public Test(Subscriber s) {
        init(s);
    }
    
    private static String ipaddress = "127.0.0.1";
    
    private Device dev;
    private DeviceUser duser;

    private void init() {
        String emsUserName = "bobby";
        //ipaddress = "192.168.1.1";
        duser = new DeviceUser(emsUserName, "admin", "admin");
        dev = new Device("mydev", duser, ipaddress, 2022);
        System.out.println("inside init");
        try {
            dev.connect(emsUserName);
            dev.newSession("cfg");
        } catch (IOException e0) {
            System.err.println("Can't connect");
            System.exit(1);
        } catch (JNCException e1) {
            System.err.println("Can't authenticate" + e1);
            System.exit(1);
        }
    }



    private void init(Subscriber sub) {
        String emsUserName = "bobby";
        duser = new DeviceUser(emsUserName, "admin", "admin");
        dev = new Device("mydev", duser, "localhost", 2022);
         try {
             dev.connect(emsUserName);
             dev.newSession(sub, "cfg");
         } catch (IOException e0) {
             System.err.println("Can't connect");
             System.exit(1);
         } catch (JNCException e1) {
             System.err.println("Can't authenticate" + e1);
             System.exit(1);
         }
    }

    /**
     * Gets the first configuration element in configs with specified name.
     * 
     * @param configs Set of device configuration data.
     * @param name The identifier of the configuration to select
     * @return First configuration with matching name, or null if none present.
     */
    Element getConfig(NodeSet configs, String name) {
        Element config = configs.first();
        if (!config.name.equals(name)) {
            config = null;
            for (Element elem : configs) {
                if (elem.name.equals(name)) {
                    config = elem;
                }
            }
        }
        return config;
    }

    NodeSet getConfig(Device d) throws IOException, JNCException{
        Simple.enable();
        NodeSet reply = d.getSession("cfg").getConfig(
NetconfSession.RUNNING);
        return reply;
    }

    void getConfig() throws IOException,JNCException{
        Simple.enable();
        System.out.println(getConfig(dev).toXMLString());
    }




    void listHosts()  throws IOException,JNCException{
        listHosts(dev);
    }

    void listHosts(Device d)  throws IOException,JNCException{
        NodeSet configs = getConfig(d);
        Hosts h = (Hosts) getConfig(configs, "hosts");
        ElementChildrenIterator it = h.hostIterator();
        while (it.hasNext()) {
            Host hst = (Host)it.next();
            System.out.println(hst.getNameValue());
        }
    }



    void updateConfig() throws IOException,JNCException {
        updateConfig(dev);
    }



    void updateConfig(Device d) throws IOException,JNCException {
    	NodeSet configs = getConfig(d);
        Hosts h = (Hosts) getConfig(configs, "hosts");
        ElementChildrenIterator it = h.hostIterator();
        while (it.hasNext()) {
            Host hst = (Host)it.next();
            if (hst.getNameValue().equals("joe"))
                hst.markDelete();
        }
        d.getSession("cfg").editConfig(h);
        // Inspect the updated RUNNING configuration
        Hosts h2 = (Hosts) getConfig(configs, "hosts");
        System.out.println("Resulting config:\n" + h2.toXMLString());
    }



    void revertConfig() throws IOException,JNCException {
        revertConfig(dev);
    }

    void revertConfig(Device d) throws IOException,JNCException {
        Hosts h = new Hosts();
        Host joe = new Host("joe");
        joe.setEnabledValue(true);
        joe.setNumberOfServersValue(5);
        joe.markReplace();
        h.addHost(joe);
        d.getSession("cfg").editConfig(h);
        // Inspect the updated RUNNING configuration
        NodeSet configs = getConfig(d);
        Hosts h2 = (Hosts) getConfig(configs, "hosts");
        System.out.println("Resulting config:\n" + h2.toXMLString());
    }

    // print small tree
    void h1() throws JNCException {
        Simple.enable();
        Hosts h = new Hosts();
        h.addHost("Jupiter").markDelete();
        h.addHost("Saturn").markDelete();
        System.out.println(h.toXMLString());
    }

    void print_cfg(String s, Device d) throws IOException, JNCException {
    	NodeSet configs = getConfig(d);
        Hosts h = (Hosts) getConfig(configs, "hosts");
         System.out.println(s + " \n" + h.toXMLString());
    }

    // Example on how to delete by explicitly constructing
    // the delete path
    void delete_vera() throws JNCException, IOException {
        print_cfg("Config With vera ", dev);
        Hosts h = new Hosts();
        Host vera = new Host("vera");
        vera.markDelete();
        h.addHost(vera);
        dev.getSession("cfg").editConfig(h);
        print_cfg("Config Without vera ", dev);
    }


    // Example on how to handle errors from the agent
    void delete_no_vera() throws JNCException, IOException, Exception {
        print_cfg("Config With vera ", dev);
        Hosts h = new Hosts();
        Host vera = new Host("vera_noExists");
        vera.markDelete();
        h.addHost(vera);
        try {
            dev.getSession("cfg").editConfig(h);
            throw new Exception("Expected0 rpc error");
        } catch (JNCException ex) {
        	String errorStr = ex.toString();
        	if (errorStr.startsWith("rpc-reply error")) {
                System.out.println("errorCode and opaqueData = " + errorStr + "\n");
            }
            else {
                throw new Exception("Expected1 rpc error");
            }
        }
    }

    // Example on how to create a Host entry - this also makes
    // it possible to run this code several times in a row
    // if it wasn't for this code - the second time we run this
    // the delete_vera() would fail - because there was no vera Host

    void create_vera() throws JNCException, IOException, Exception {
        print_cfg("Create vera ", dev);
        Hosts h = new Hosts();
        Host vera = new Host("vera");
        vera.setNumberOfServersValue(0);
        h.addHost(vera);
        dev.getSession("cfg").editConfig(h);
    }

    // Create an additional host
    void create_vera_space() throws JNCException, IOException, Exception {
        print_cfg("Create vera space", dev);
        Hosts h = new Hosts();
        Host vera = new Host("vera space");
        vera.setNumberOfServersValue(0);
        vera.setDomainAValue("1000");
        vera.setDomainAValue("1001");
        h.addHost(vera);
        dev.getSession("cfg").editConfig(h);
    }




    void writeReadFile() throws Exception {
        Simplelist.enable();
    	Simple.enable();
        Hosts h = new Hosts();
        h.addHost("Jupiter");
        h.addHost("Saturn");
        h.writeFile("Hosts.xml");
        Hosts h2 = (Hosts)YangElement.readFile("Hosts.xml");
        System.out.println(h2.toXMLString());
    }


    // actions cannot be constructed - nor can the reply be
    // deconstructed using generated JNC classes - rather
    // the more primitive Element class must be used

    void invokeAction() throws Exception {

      Element e = Element.create(
          Simple.NAMESPACE, "/hosts/sys/restart");
      Element restart = e.getChildren().first().getChildren().first();
      restart.createChild("mode", "mymode");
      restart.createChild("debug");
      System.out.println("Data = " +  e.toXMLString());
      Element reply = dev.getSession("cfg").action(e);
      System.out.println("Reply = " +  reply.toXMLString());

    }
    
    
    void addUser()  throws IOException,JNCException, ClassCastException{
    	
    	NetconfSession netconfsession = dev.getSession("cfg");       
        NodeSet nodeSet = netconfsession.getConfig(NetconfSession.RUNNING, "/user-list/user");
        Element element = nodeSet.first();
        ElementChildrenIterator it = element.iterator();
        while (it.hasNext()) {
          System.out.println(it.next());
        }
        //displayElement(element);
        
        element.setValue("user", "SRK");
        netconfsession.editConfig(NetconfSession.RUNNING, nodeSet);


        element = nodeSet.first();
        it = element.iterator();
        while (it.hasNext()) {
          System.out.println(it.next());
        }
       // displayElement(element);
        
        nodeSet = netconfsession.getConfig(
        		NetconfSession.RUNNING, "/user-list/user");
        element = nodeSet.first();
        it = element.iterator();
        while (it.hasNext()) {
          System.out.println(it.next());
        }
       // displayElement(element);
    }
    
    void addUser1(String name)  throws IOException,JNCException, ClassCastException{
    	
    	NetconfSession netconfsession = dev.getSession("cfg");
    	
    	System.out.println("Session Got " + netconfsession);
    	
//    	NodeSet nodeSet = netconfsession.getConfig(
//        		NetconfSession.RUNNING);
//    	
//        Element element = nodeSet.first();
//        ElementChildrenIterator it = element.iterator();
//        while (it.hasNext()) {
//          System.out.println(it.next());
//        }
        
        
        NodeSet nodeSet = netconfsession.getConfig(NetconfSession.RUNNING, "/user-list/user");
        Element element = nodeSet.first();
        ElementChildrenIterator it = element.iterator();
        while (it.hasNext()) {
          System.out.println(it.next());
        }
        //displayElement(element);
        System.out.println("First Element is " + element);
        element.setValue("user", name);
        netconfsession.editConfig(NetconfSession.RUNNING, nodeSet);


        element = nodeSet.first();
        it = element.iterator();
        while (it.hasNext()) {
          System.out.println(it.next());
        }
       // displayElement(element);
        
        nodeSet = netconfsession.getConfig(
        		NetconfSession.RUNNING, "/user-list/user");
        element = nodeSet.first();
        it = element.iterator();
        while (it.hasNext()) {
          System.out.println(it.next());
        }
       // displayElement(element);
    }
    
    void addUser2(String name, String ipaddress1)  throws IOException,JNCException, ClassCastException{
    	ipaddress = ipaddress1;
    	NetconfSession netconfsession = dev.getSession("cfg");
//    	NodeSet nodeSet = netconfsession.getConfig(
//        		NetconfSession.RUNNING);
//    	
//        Element element = nodeSet.first();
//        ElementChildrenIterator it = element.iterator();
//        while (it.hasNext()) {
//          System.out.println(it.next());
//        }
        
        
        NodeSet nodeSet = netconfsession.getConfig(NetconfSession.RUNNING, "/user-list/user");
        Element element = nodeSet.first();
        ElementChildrenIterator it = element.iterator();
        while (it.hasNext()) {
          System.out.println(it.next());
        }
        //displayElement(element);
        
        element.setValue("user", name);
        netconfsession.editConfig(NetconfSession.RUNNING, nodeSet);


        element = nodeSet.first();
        it = element.iterator();
        while (it.hasNext()) {
          System.out.println(it.next());
        }
       // displayElement(element);
        
        nodeSet = netconfsession.getConfig(
        		NetconfSession.RUNNING, "/user-list/user");
        element = nodeSet.first();
        it = element.iterator();
        while (it.hasNext()) {
          System.out.println(it.next());
        }
    }
    
    void delUser1()  throws IOException,JNCException, ClassCastException{
    	
    	NetconfSession netconfsession = dev.getSession("cfg");
    	NodeSet nodeSet = netconfsession.getConfig(
        		NetconfSession.RUNNING, "/user-list/user");
	           
        Element element = nodeSet.first();
        ElementChildrenIterator it = element.iterator();
        while (it.hasNext()) {
          System.out.println(it.next());
        }
        element.markDelete();
        netconfsession.editConfig(element);
       	nodeSet = netconfsession.getConfig(NetconfSession.RUNNING, "/user-list/user");
    }
    
    void delUser(String namevalue)  throws IOException,JNCException, ClassCastException{
    	
    	NetconfSession netconfsession = dev.getSession("cfg");
    	NodeSet nodeSet = netconfsession.getConfig(
        		NetconfSession.RUNNING, "/user-list/user");
    	Element element, child;
    	ElementChildrenIterator it;
    	String namevalue1;
    	ListIterator<Element> elementIterator = nodeSet.listIterator();
    	while(elementIterator.hasNext()) {
    		element = elementIterator.next();
            it = element.iterator();          
            while (it.hasNext()) {
            	System.out.println("=============================");
            	child = it.next();
            	namevalue1 = child.getValue().toString();
              	System.out.println("Value is " + namevalue1);
              	if (namevalue1.equals(namevalue)) {
              		System.out.println("Given name matches with the user list and will be deleted");
              		element.markDelete();
              		netconfsession.editConfig(element);
              		continue;
              	}
//            	System.out.println(it.next());
            	System.out.println(child);
            }
            System.out.println("*************************************");
    	}
    }
    
    void delUser2(String namevalue, String ipaddress1)  throws IOException,JNCException, ClassCastException{
    	ipaddress = ipaddress1;
    	NetconfSession netconfsession = dev.getSession("cfg");
    	NodeSet nodeSet = netconfsession.getConfig(
        		NetconfSession.RUNNING, "/user-list/user");
    	Element element, child;
    	ElementChildrenIterator it;
    	String namevalue1;
    	ListIterator<Element> elementIterator = nodeSet.listIterator();
    	while(elementIterator.hasNext()) {
    		element = elementIterator.next();
            it = element.iterator();          
            while (it.hasNext()) {
            	System.out.println("=============================");
            	child = it.next();
            	namevalue1 = child.getValue().toString();
              	System.out.println("Value is " + namevalue1);
              	if (namevalue1.equals(namevalue)) {
              		System.out.println("Given name matches with the user list and will be deleted");
              		element.markDelete();
              		netconfsession.editConfig(element);
              		continue;
              	}
//            	System.out.println(it.next());
            	System.out.println(child);
            }
            System.out.println("*************************************");
    	}
    }
    
    List<String> showUserConsole()  throws IOException,JNCException, ClassCastException{
    	
    	NetconfSession netconfsession = dev.getSession("cfg");
    	NodeSet nodeSet = netconfsession.getConfig(
        		NetconfSession.RUNNING, "/user-list/user");
    	ListIterator<Element> elementIterator = nodeSet.listIterator();
    	List<String> userlist = new ArrayList<String>();
    	while(elementIterator.hasNext()) {
    		Element element = elementIterator.next();
    		System.out.println(element);
            ElementChildrenIterator it = element.iterator();
            
            while (it.hasNext()) {
            	System.out.println("=============================");
            	Element child = it.next();
            	String namevalue = child.getValue().toString();
            	userlist.add(namevalue);
              	System.out.println("Value is " + namevalue);
//            	System.out.println(it.next());
            	System.out.println(child);
            }
            System.out.println("*************************************");
    	}
    	System.out.println("User List is " + userlist);
    	return userlist;
    }
    
    List<String> showUserConsole1(String ipaddress1)  throws IOException,JNCException, ClassCastException{
    	ipaddress = ipaddress1;
    	NetconfSession netconfsession = dev.getSession("cfg");
    	NodeSet nodeSet = netconfsession.getConfig(
        		NetconfSession.RUNNING, "/user-list/user");
    	ListIterator<Element> elementIterator = nodeSet.listIterator();
    	List<String> userlist = new ArrayList<String>();
    	while(elementIterator.hasNext()) {
    		Element element = elementIterator.next();
    		System.out.println(element);
            ElementChildrenIterator it = element.iterator();
            
            while (it.hasNext()) {
            	System.out.println("=============================");
            	Element child = it.next();
            	String namevalue = child.getValue().toString();
            	userlist.add(namevalue);
              	System.out.println("Value is " + namevalue);
//            	System.out.println(it.next());
            	System.out.println(child);
            }
            System.out.println("*************************************");
    	}
    	System.out.println("User List is " + userlist);
    	return userlist;
    }
    
    void delUser1(String name)  throws IOException,JNCException, ClassCastException{
    	
    	NetconfSession netconfsession = dev.getSession("cfg");
    	NodeSet nodeSet = netconfsession.getConfig(
        		NetconfSession.RUNNING, "/user-list/user");
    	ListIterator<Element> elementIterator = nodeSet.listIterator();
  	
    	while(elementIterator.hasNext()) {
    		Element element = elementIterator.next();
            ElementChildrenIterator it = element.iterator();
            
            while (it.hasNext()) {
            	
                System.out.println(it.next());

            }
    	}
    }
    
    
    void getUsers()  throws Exception {

    	NetconfSession netconfsession = dev.getSession("cfg");
    	NodeSet nodeSet = netconfsession.getConfig(
        		NetconfSession.CANDIDATE);
    	
        Element element = nodeSet.first();
        
        ElementChildrenIterator it = element.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    	
    }
    
    String sysName()  throws IOException,JNCException, ClassCastException{
    	
    	NetconfSession netconfsession = dev.getSession("cfg");
    	NodeSet nodeSet = netconfsession.getConfig(
        		NetconfSession.RUNNING, "/host-name");
    	
    	Element element = nodeSet.first();
    	String sysname = element.getValue().toString();
    	
    	//String sysname = nodeSet.toString();
    	System.out.println("Element  is " + element.toString());
    	System.out.println("Element  has Children or Not " + element.hasChildren());
    	
    	System.out.println("System Name is " + element.getValue());
    	return sysname;
    }
    
    String sysName1(String ipaddress1)  throws IOException,JNCException, ClassCastException{
    	
    	ipaddress = ipaddress1;
    	NetconfSession netconfsession = dev.getSession("cfg");
    	NodeSet nodeSet = netconfsession.getConfig(
        		NetconfSession.RUNNING, "/host-name");
    	
    	Element element = nodeSet.first();
    	String sysname = element.getValue().toString();
    	
    	//String sysname = nodeSet.toString();
    	System.out.println("Element  is " + element.toString());
    	System.out.println("Element  has Children or Not " + element.hasChildren());
    	
    	System.out.println("System Name is " + element.getValue());
    	return sysname;
    }

}

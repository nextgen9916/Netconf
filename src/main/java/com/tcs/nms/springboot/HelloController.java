package com.tcs.nms.springboot;

import org.springframework.web.bind.annotation.RestController;

import gen.com.example.test.hosts.Simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping(value = "/RemoveUser", method = RequestMethod.POST)
    public String process2(@RequestBody Map<String, String> payload) throws Exception {
	    System.out.println(payload);
	    String name = payload.get("name");
	    Test test = new Test();
	    try {
	    test.delUser(name);
	    System.out.println(name + " is deleted");
	    } catch (Exception e) {
		  System.err.println(e);
		  System.exit(1);
	    }
	    return name + " is deleted";
    }
    
    @RequestMapping(value = "/RemoveUser1", method = RequestMethod.POST)
    public String process5(@RequestBody Map<String, String> payload) throws Exception {
	    System.out.println(payload);
	    String name = payload.get("name");
	    String ipaddress = payload.get("ipaddress");
	    Test test = new Test();
	    try {
	    test.delUser2(name, ipaddress);
	    System.out.println();
	    } catch (Exception e) {
		  System.err.println(e);
		  System.exit(1);
	    }
	    return name + " is removed at " + ipaddress;
    }
    
    @RequestMapping(value = "/AddUser", method = RequestMethod.POST)
    public String process1(@RequestBody Map<String, String> payload) throws Exception {
	    System.out.println(payload);
	    String name = payload.get("name");
	    Test test = new Test("127.0.0.1");
	    System.out.println("Test Object is created");
	    try {
	    test.addUser1(name);
	    System.out.println(name + " is added");
	    
	    } catch (Exception e) {
		  System.err.println(e);
		  //System.exit(1);
	    }
	    return name + " is added";
    }
    
    @RequestMapping(value = "/AddUser1", method = RequestMethod.POST)
    public String process4(@RequestBody Map<String, String> payload) throws Exception {
	    System.out.println(payload);
	    String name = payload.get("name");
	    String ipaddress = payload.get("ipaddress");
	    Test test = new Test();
	    try {
	    test.addUser2(name, ipaddress);
	    System.out.println(name + " is added at " + ipaddress);
	    } catch (Exception e) {
		  System.err.println(e);
		  System.exit(1);
	    }
	    return name + " is added at " + ipaddress;
    }
    
    @RequestMapping(value = "/AddUser2", method = RequestMethod.PUT)
    public String process6(@RequestBody Map<String, String> payload) throws Exception {
	    System.out.println(payload);
	    String name = payload.get("name");
	    String ipaddress = payload.get("ipaddress");
	    Test test = new Test();
	    try {
	    test.addUser2(name, ipaddress);
	    System.out.println(name + " is added at " + ipaddress);
	    } catch (Exception e) {
		  System.err.println(e);
		  System.exit(1);
	    }
	    return name + " is added at " + ipaddress;
    }

    @RequestMapping("/ShowUsers")
    public List<String> index1() {
        Netconf netconf = new Netconf();
        List<String> userlist = new ArrayList<String>();
    	try {
            Simple.enable();
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    	Test test = new Test();
    	try {
    	userlist = test.showUserConsole();
    	} catch (Exception e) {
    		System.err.println(e);
    		System.exit(1);
    	}    	
        return userlist;
    }

    @RequestMapping(value = "/ShowUsers1", method = RequestMethod.POST)
    public List<String> process3(@RequestBody Map<String, String> payload) throws Exception {
	    System.out.println(payload);
	    
	    String ipaddress = payload.get("ipaddress");
	    Test test = new Test(ipaddress);
	    List<String> userlist = new ArrayList<String>();
	    
	    try {
	    userlist = test.showUserConsole1(ipaddress);
	    System.out.println("ip address is " + ipaddress);
	    } catch (Exception e) {
		  System.err.println(e);
		  System.exit(1);
	    }
	    return userlist;
    }
    
    @RequestMapping("/SysName1")
    public String sys1() {
//        Netconf netconf = new Netconf();
        String sysname = null;
    	try {
            Simple.enable();
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    	Test test = new Test();
    	try {
    	sysname = test.sysName();
    	} catch (Exception e) {
    		System.err.println(e);
    		System.exit(1);
    	}    	
        return sysname;
    }
    
    @RequestMapping(value = "/SysName", method = RequestMethod.POST) 
    	public String sys2(@RequestBody Map<String, String> payload) throws Exception {
    	String ipaddress = payload.get("ipaddress");
    	String sysname = null;
    	try {
            Simple.enable();
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    	Test test = new Test();
    	try {
    	sysname = test.sysName1(ipaddress);
    	} catch (Exception e) {
    		System.err.println(e);
    		System.exit(1);
    	}    	
        return sysname;
    	}
    }


/* 
 * @(#)Host.java        1.0 16/08/17
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "hosts", revision: "unknown".
 */

package gen.com.example.test.hosts.hosts;

import com.tailf.jnc.Element;
import com.tailf.jnc.ElementLeafListValueIterator;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.Leaf;
import com.tailf.jnc.YangBoolean;
import com.tailf.jnc.YangElement;
import com.tailf.jnc.YangString;
import com.tailf.jnc.YangUInt64;

import gen.com.example.test.hosts.Conny;
import gen.com.example.test.hosts.Simple;
import gen.com.example.test.ietfInetTypes.Ipv4Address;

import java.math.BigInteger;

/**
 * This class represents an element from 
 * the namespace http://acme.com/ns/simple/1.0
 * generated to "src/gen/com/example/test/hosts/hosts/host"
 * <p>
 * See line 22 in
 * ../yang/hosts.yang
 *
 * @version 1.0 2017-08-16
 * @author Auto Generated
 */
public class Host extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for an empty Host object.
     */
    public Host() {
        super(Simple.NAMESPACE, "host");
    }

    /**
     * Constructor for an initialized Host object,
     * 
     * @param nameValue Key argument of child.
     */
    public Host(YangString nameValue) throws JNCException {
        super(Simple.NAMESPACE, "host");
        Leaf name = new Leaf(Simple.NAMESPACE, "name");
        name.setValue(nameValue);
        insertChild(name, childrenNames());
    }

    /**
     * Constructor for an initialized Host object,
     * with String keys.
     * @param nameValue Key argument of child.
     */
    public Host(String nameValue) throws JNCException {
        super(Simple.NAMESPACE, "host");
        Leaf name = new Leaf(Simple.NAMESPACE, "name");
        name.setValue(new YangString(nameValue));
        insertChild(name, childrenNames());
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public Host clone() {
        Host copy;
        try {
            copy = new Host(getNameValue().toString());
        } catch (JNCException e) {
            copy = null;
        }
        return (Host)cloneContent(copy);
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public Host cloneShallow() {
        Host copy;
        try {
            copy = new Host(getNameValue().toString());
        } catch (JNCException e) {
            copy = null;
        }
        return (Host)cloneShallowContent(copy);
    }

    /**
     * @return An array with the identifiers of any key children
     */
    public String[] keyNames() {
        return new String[] {
            "name",
        };
    }

    /**
     * @return An array with the identifiers of any children, in order.
     */
    public String[] childrenNames() {
        return new String[] {
            "name",
            "ip",
            "enabled",
            "numberOfServers",
            "domainA",
            "domainB",
            "domainC",
        };
    }

    /* Access methods for leaf child: "name". */

    /**
     * Gets the value for child leaf "name".
     * @return The value of the leaf.
     */
    public YangString getNameValue() throws JNCException {
        return (YangString)getValue("name");
    }

    /**
     * Sets the value for child leaf "name",
     * using instance of generated typedef class.
     * @param nameValue The value to set.
     * @param nameValue used during instantiation.
     */
    public void setNameValue(YangString nameValue) throws JNCException {
        setLeafValue(Simple.NAMESPACE,
            "name",
            nameValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "name",
     * using a String value.
     * @param nameValue used during instantiation.
     */
    public void setNameValue(String nameValue) throws JNCException {
        setNameValue(new YangString(nameValue));
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "name" leaf will not have a value.
     */
    public void addName() throws JNCException {
        setLeafValue(Simple.NAMESPACE,
            "name",
            null,
            childrenNames());
    }

    /* Access methods for optional leaf child: "ip". */

    /**
     * Gets the value for child leaf "ip".
     * @return The value of the leaf.
     */
    public Ipv4Address getIpValue() throws JNCException {
        return (Ipv4Address)getValue("ip");
    }

    /**
     * Sets the value for child leaf "ip",
     * using a JNC type value.
     * @param ipValue The value to set.
     * @param ipValue used during instantiation.
     */
    public void setIpValue(Ipv4Address ipValue) throws JNCException {
        setLeafValue(Simple.NAMESPACE,
            "ip",
            ipValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "ip",
     * using a String value.
     * @param ipValue used during instantiation.
     */
    public void setIpValue(String ipValue) throws JNCException {
        setIpValue(new Ipv4Address(ipValue));
    }

    /**
     * Unsets the value for child leaf "ip".
     */
    public void unsetIpValue() throws JNCException {
        delete("ip");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "ip" leaf will not have a value.
     */
    public void addIp() throws JNCException {
        setLeafValue(Simple.NAMESPACE,
            "ip",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "ip" with operation "replace".
     */
    public void markIpReplace() throws JNCException {
        markLeafReplace("ip");
    }

    /**
     * Marks the leaf "ip" with operation "merge".
     */
    public void markIpMerge() throws JNCException {
        markLeafMerge("ip");
    }

    /**
     * Marks the leaf "ip" with operation "create".
     */
    public void markIpCreate() throws JNCException {
        markLeafCreate("ip");
    }

    /**
     * Marks the leaf "ip" with operation "delete".
     */
    public void markIpDelete() throws JNCException {
        markLeafDelete("ip");
    }

    /* Access methods for optional leaf child: "enabled". */

    /**
     * Gets the value for child leaf "enabled".
     * @return The value of the leaf.
     */
    public YangBoolean getEnabledValue() throws JNCException {
        YangBoolean enabled = (YangBoolean)getValue("enabled");
        if (enabled == null) {
            enabled = new YangBoolean("true");  // default
        }
        return enabled;
    }

    /**
     * Sets the value for child leaf "enabled",
     * using instance of generated typedef class.
     * @param enabledValue The value to set.
     * @param enabledValue used during instantiation.
     */
    public void setEnabledValue(YangBoolean enabledValue) throws JNCException {
        setLeafValue(Simple.NAMESPACE,
            "enabled",
            enabledValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "enabled",
     * using Java primitive values.
     * @param enabledValue used during instantiation.
     */
    public void setEnabledValue(Boolean enabledValue) throws JNCException {
        setEnabledValue(new YangBoolean(enabledValue));
    }

    /**
     * Sets the value for child leaf "enabled",
     * using a String value.
     * @param enabledValue used during instantiation.
     */
    public void setEnabledValue(String enabledValue) throws JNCException {
        setEnabledValue(new YangBoolean(enabledValue));
    }

    /**
     * Unsets the value for child leaf "enabled".
     */
    public void unsetEnabledValue() throws JNCException {
        delete("enabled");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "enabled" leaf will not have a value.
     */
    public void addEnabled() throws JNCException {
        setLeafValue(Simple.NAMESPACE,
            "enabled",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "enabled" with operation "replace".
     */
    public void markEnabledReplace() throws JNCException {
        markLeafReplace("enabled");
    }

    /**
     * Marks the leaf "enabled" with operation "merge".
     */
    public void markEnabledMerge() throws JNCException {
        markLeafMerge("enabled");
    }

    /**
     * Marks the leaf "enabled" with operation "create".
     */
    public void markEnabledCreate() throws JNCException {
        markLeafCreate("enabled");
    }

    /**
     * Marks the leaf "enabled" with operation "delete".
     */
    public void markEnabledDelete() throws JNCException {
        markLeafDelete("enabled");
    }

    /* Access methods for optional leaf child: "numberOfServers". */

    /**
     * Gets the value for child leaf "numberOfServers".
     * @return The value of the leaf.
     */
    public Conny getNumberOfServersValue() throws JNCException {
        return (Conny)getValue("numberOfServers");
    }

    /**
     * Sets the value for child leaf "numberOfServers",
     * using a JNC type value.
     * @param numberOfServersValue The value to set.
     * @param numberOfServersValue used during instantiation.
     */
    public void setNumberOfServersValue(Conny numberOfServersValue)
            throws JNCException {
        setLeafValue(Simple.NAMESPACE,
            "numberOfServers",
            numberOfServersValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "numberOfServers",
     * using Java primitive values.
     * @param numberOfServersValue used during instantiation.
     */
    public void setNumberOfServersValue(long numberOfServersValue)
            throws JNCException {
        setNumberOfServersValue(new Conny(numberOfServersValue));
    }

    /**
     * Sets the value for child leaf "numberOfServers",
     * using a String value.
     * @param numberOfServersValue used during instantiation.
     */
    public void setNumberOfServersValue(String numberOfServersValue)
            throws JNCException {
        setNumberOfServersValue(new Conny(numberOfServersValue));
    }

    /**
     * Unsets the value for child leaf "numberOfServers".
     */
    public void unsetNumberOfServersValue() throws JNCException {
        delete("numberOfServers");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "numberOfServers" leaf will not have a value.
     */
    public void addNumberOfServers() throws JNCException {
        setLeafValue(Simple.NAMESPACE,
            "numberOfServers",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "numberOfServers" with operation "replace".
     */
    public void markNumberOfServersReplace() throws JNCException {
        markLeafReplace("numberOfServers");
    }

    /**
     * Marks the leaf "numberOfServers" with operation "merge".
     */
    public void markNumberOfServersMerge() throws JNCException {
        markLeafMerge("numberOfServers");
    }

    /**
     * Marks the leaf "numberOfServers" with operation "create".
     */
    public void markNumberOfServersCreate() throws JNCException {
        markLeafCreate("numberOfServers");
    }

    /**
     * Marks the leaf "numberOfServers" with operation "delete".
     */
    public void markNumberOfServersDelete() throws JNCException {
        markLeafDelete("numberOfServers");
    }

    /* Access methods for optional leaf-list child: "domainA". */

    /**
     * Iterator method for the leaf-list "domainA".
     * @return An iterator for the leaf-list.
     */
    public ElementLeafListValueIterator domainAIterator() {
        return new ElementLeafListValueIterator(children, "domainA");
    }

    /**
     * Sets the value for child leaf-list "domainA",
     * using instance of generated typedef class.
     * @param domainAValue The value to set.
     * @param domainAValue used during instantiation.
     */
    public void setDomainAValue(YangUInt64 domainAValue) throws JNCException {
        setLeafListValue(Simple.NAMESPACE,
            "domainA",
            domainAValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf-list "domainA",
     * using Java primitive values.
     * @param domainAValue used during instantiation.
     */
    public void setDomainAValue(BigInteger domainAValue) throws JNCException {
        setDomainAValue(new YangUInt64(domainAValue));
    }

    /**
     * Sets the value for child leaf-list "domainA",
     * using a String value.
     * @param domainAValue used during instantiation.
     */
    public void setDomainAValue(String domainAValue) throws JNCException {
        setDomainAValue(new YangUInt64(domainAValue));
    }

    /**
     * Deletes leaf-list entry "domainA".
     * @param domainAValue Value to delete.
     */
    public void deleteDomainA(YangUInt64 domainAValue) throws JNCException {
        String path = "domainA[domainAValue]";
        delete(path);
    }

    /**
     * Deletes leaf-list entry "domainA".
     * The value is specified as a string.
     * @param domainAValue Value to delete.
     */
    public void deleteDomainA(String domainAValue) throws JNCException {
        String path = "domainA[domainAValue]";
        delete(path);
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "domainA" leaf-list will not have a value.
     */
    public void addDomainA() throws JNCException {
        setLeafListValue(Simple.NAMESPACE,
            "domainA",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf-list "domainA" with operation "replace".
     * @param domainAValue The value to mark
     */
    public void markDomainAReplace(YangUInt64 domainAValue) throws JNCException {
        markLeafReplace("domainA[name='" + domainAValue + "']");
    }

    /**
     * Marks the leaf-list "domainA" with operation "replace".
     * @param domainAValue The value to mark, given as a String
     */
    public void markDomainAReplace(String domainAValue) throws JNCException {
        markLeafReplace("domainA[name='" + domainAValue + "']");
    }

    /**
     * Marks the leaf-list "domainA" with operation "merge".
     * @param domainAValue The value to mark
     */
    public void markDomainAMerge(YangUInt64 domainAValue) throws JNCException {
        markLeafMerge("domainA[name='" + domainAValue + "']");
    }

    /**
     * Marks the leaf-list "domainA" with operation "merge".
     * @param domainAValue The value to mark, given as a String
     */
    public void markDomainAMerge(String domainAValue) throws JNCException {
        markLeafMerge("domainA[name='" + domainAValue + "']");
    }

    /**
     * Marks the leaf-list "domainA" with operation "create".
     * @param domainAValue The value to mark
     */
    public void markDomainACreate(YangUInt64 domainAValue) throws JNCException {
        markLeafCreate("domainA[name='" + domainAValue + "']");
    }

    /**
     * Marks the leaf-list "domainA" with operation "create".
     * @param domainAValue The value to mark, given as a String
     */
    public void markDomainACreate(String domainAValue) throws JNCException {
        markLeafCreate("domainA[name='" + domainAValue + "']");
    }

    /**
     * Marks the leaf-list "domainA" with operation "delete".
     * @param domainAValue The value to mark
     */
    public void markDomainADelete(YangUInt64 domainAValue) throws JNCException {
        markLeafDelete("domainA[name='" + domainAValue + "']");
    }

    /**
     * Marks the leaf-list "domainA" with operation "delete".
     * @param domainAValue The value to mark, given as a String
     */
    public void markDomainADelete(String domainAValue) throws JNCException {
        markLeafDelete("domainA[name='" + domainAValue + "']");
    }

    /* Access methods for optional leaf-list child: "domainB". */

    /**
     * Iterator method for the leaf-list "domainB".
     * @return An iterator for the leaf-list.
     */
    public ElementLeafListValueIterator domainBIterator() {
        return new ElementLeafListValueIterator(children, "domainB");
    }

    /**
     * Sets the value for child leaf-list "domainB",
     * using instance of generated typedef class.
     * @param domainBValue The value to set.
     * @param domainBValue used during instantiation.
     */
    public void setDomainBValue(YangString domainBValue) throws JNCException {
        setLeafListValue(Simple.NAMESPACE,
            "domainB",
            domainBValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf-list "domainB",
     * using a String value.
     * @param domainBValue used during instantiation.
     */
    public void setDomainBValue(String domainBValue) throws JNCException {
        setDomainBValue(new YangString(domainBValue));
    }

    /**
     * Deletes leaf-list entry "domainB".
     * @param domainBValue Value to delete.
     */
    public void deleteDomainB(YangString domainBValue) throws JNCException {
        String path = "domainB[domainBValue]";
        delete(path);
    }

    /**
     * Deletes leaf-list entry "domainB".
     * The value is specified as a string.
     * @param domainBValue Value to delete.
     */
    public void deleteDomainB(String domainBValue) throws JNCException {
        String path = "domainB[domainBValue]";
        delete(path);
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "domainB" leaf-list will not have a value.
     */
    public void addDomainB() throws JNCException {
        setLeafListValue(Simple.NAMESPACE,
            "domainB",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf-list "domainB" with operation "replace".
     * @param domainBValue The value to mark
     */
    public void markDomainBReplace(YangString domainBValue) throws JNCException {
        markLeafReplace("domainB[name='" + domainBValue + "']");
    }

    /**
     * Marks the leaf-list "domainB" with operation "merge".
     * @param domainBValue The value to mark
     */
    public void markDomainBMerge(YangString domainBValue) throws JNCException {
        markLeafMerge("domainB[name='" + domainBValue + "']");
    }

    /**
     * Marks the leaf-list "domainB" with operation "create".
     * @param domainBValue The value to mark
     */
    public void markDomainBCreate(YangString domainBValue) throws JNCException {
        markLeafCreate("domainB[name='" + domainBValue + "']");
    }

    /**
     * Marks the leaf-list "domainB" with operation "delete".
     * @param domainBValue The value to mark
     */
    public void markDomainBDelete(YangString domainBValue) throws JNCException {
        markLeafDelete("domainB[name='" + domainBValue + "']");
    }

    /* Access methods for optional leaf-list child: "domainC". */

    /**
     * Iterator method for the leaf-list "domainC".
     * @return An iterator for the leaf-list.
     */
    public ElementLeafListValueIterator domainCIterator() {
        return new ElementLeafListValueIterator(children, "domainC");
    }

    /**
     * Sets the value for child leaf-list "domainC",
     * using a JNC type value.
     * @param domainCValue The value to set.
     * @param domainCValue used during instantiation.
     */
    public void setDomainCValue(Conny domainCValue) throws JNCException {
        setLeafListValue(Simple.NAMESPACE,
            "domainC",
            domainCValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf-list "domainC",
     * using Java primitive values.
     * @param domainCValue used during instantiation.
     */
    public void setDomainCValue(long domainCValue) throws JNCException {
        setDomainCValue(new Conny(domainCValue));
    }

    /**
     * Sets the value for child leaf-list "domainC",
     * using a String value.
     * @param domainCValue used during instantiation.
     */
    public void setDomainCValue(String domainCValue) throws JNCException {
        setDomainCValue(new Conny(domainCValue));
    }

    /**
     * Deletes leaf-list entry "domainC".
     * @param domainCValue Value to delete.
     */
    public void deleteDomainC(Conny domainCValue) throws JNCException {
        String path = "domainC[domainCValue]";
        delete(path);
    }

    /**
     * Deletes leaf-list entry "domainC".
     * The value is specified as a string.
     * @param domainCValue Value to delete.
     */
    public void deleteDomainC(String domainCValue) throws JNCException {
        String path = "domainC[domainCValue]";
        delete(path);
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "domainC" leaf-list will not have a value.
     */
    public void addDomainC() throws JNCException {
        setLeafListValue(Simple.NAMESPACE,
            "domainC",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf-list "domainC" with operation "replace".
     * @param domainCValue The value to mark
     */
    public void markDomainCReplace(Conny domainCValue) throws JNCException {
        markLeafReplace("domainC[name='" + domainCValue + "']");
    }

    /**
     * Marks the leaf-list "domainC" with operation "replace".
     * @param domainCValue The value to mark, given as a String
     */
    public void markDomainCReplace(String domainCValue) throws JNCException {
        markLeafReplace("domainC[name='" + domainCValue + "']");
    }

    /**
     * Marks the leaf-list "domainC" with operation "merge".
     * @param domainCValue The value to mark
     */
    public void markDomainCMerge(Conny domainCValue) throws JNCException {
        markLeafMerge("domainC[name='" + domainCValue + "']");
    }

    /**
     * Marks the leaf-list "domainC" with operation "merge".
     * @param domainCValue The value to mark, given as a String
     */
    public void markDomainCMerge(String domainCValue) throws JNCException {
        markLeafMerge("domainC[name='" + domainCValue + "']");
    }

    /**
     * Marks the leaf-list "domainC" with operation "create".
     * @param domainCValue The value to mark
     */
    public void markDomainCCreate(Conny domainCValue) throws JNCException {
        markLeafCreate("domainC[name='" + domainCValue + "']");
    }

    /**
     * Marks the leaf-list "domainC" with operation "create".
     * @param domainCValue The value to mark, given as a String
     */
    public void markDomainCCreate(String domainCValue) throws JNCException {
        markLeafCreate("domainC[name='" + domainCValue + "']");
    }

    /**
     * Marks the leaf-list "domainC" with operation "delete".
     * @param domainCValue The value to mark
     */
    public void markDomainCDelete(Conny domainCValue) throws JNCException {
        markLeafDelete("domainC[name='" + domainCValue + "']");
    }

    /**
     * Marks the leaf-list "domainC" with operation "delete".
     * @param domainCValue The value to mark, given as a String
     */
    public void markDomainCDelete(String domainCValue) throws JNCException {
        markLeafDelete("domainC[name='" + domainCValue + "']");
    }

    /**
     * Support method for addChild.
     * Adds a child to this object.
     * 
     * @param child The child to add
     */
    public void addChild(Element child) {
        super.addChild(child);
    }

}
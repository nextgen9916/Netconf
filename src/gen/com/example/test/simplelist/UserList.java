/* 
 * @(#)UserList.java        1.0 16/08/17
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "simplelist", revision: "2017-07-12".
 */

package gen.com.example.test.simplelist;

import com.tailf.jnc.Element;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.Leaf;
import com.tailf.jnc.YangElement;
import com.tailf.jnc.YangString;

import gen.com.example.test.simplelist.Simplelist;

/**
 * This class represents an element from 
 * the namespace http://example.com/ns/userlist
 * generated to "src/gen/com/example/test/simplelist/user-list"
 * <p>
 * See line 10 in
 * ../yang/simplelist.yang
 *
 * @version 1.0 2017-08-16
 * @author Auto Generated
 */
public class UserList extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for an empty UserList object.
     */
    public UserList() {
        super(Simplelist.NAMESPACE, "user-list");
        setDefaultPrefix();
        setPrefix(Simplelist.PREFIX);
    }

    /**
     * Constructor for an initialized UserList object,
     * 
     * @param userValue Key argument of child.
     */
    public UserList(YangString userValue) throws JNCException {
        super(Simplelist.NAMESPACE, "user-list");
        setDefaultPrefix();
        setPrefix(Simplelist.PREFIX);
        Leaf user = new Leaf(Simplelist.NAMESPACE, "user");
        user.setValue(userValue);
        insertChild(user, childrenNames());
    }

    /**
     * Constructor for an initialized UserList object,
     * with String keys.
     * @param userValue Key argument of child.
     */
    public UserList(String userValue) throws JNCException {
        super(Simplelist.NAMESPACE, "user-list");
        setDefaultPrefix();
        setPrefix(Simplelist.PREFIX);
        Leaf user = new Leaf(Simplelist.NAMESPACE, "user");
        user.setValue(new YangString(userValue));
        insertChild(user, childrenNames());
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public UserList clone() {
        UserList copy;
        try {
            copy = new UserList(getUserValue().toString());
        } catch (JNCException e) {
            copy = null;
        }
        return (UserList)cloneContent(copy);
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public UserList cloneShallow() {
        UserList copy;
        try {
            copy = new UserList(getUserValue().toString());
        } catch (JNCException e) {
            copy = null;
        }
        return (UserList)cloneShallowContent(copy);
    }

    /**
     * @return An array with the identifiers of any key children
     */
    public String[] keyNames() {
        return new String[] {
            "user",
        };
    }

    /**
     * @return An array with the identifiers of any children, in order.
     */
    public String[] childrenNames() {
        return new String[] {
            "user",
            "group",
        };
    }

    /* Access methods for leaf child: "user". */

    /**
     * Gets the value for child leaf "user".
     * @return The value of the leaf.
     */
    public YangString getUserValue() throws JNCException {
        return (YangString)getValue("user");
    }

    /**
     * Sets the value for child leaf "user",
     * using instance of generated typedef class.
     * @param userValue The value to set.
     * @param userValue used during instantiation.
     */
    public void setUserValue(YangString userValue) throws JNCException {
        setLeafValue(Simplelist.NAMESPACE,
            "user",
            userValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "user",
     * using a String value.
     * @param userValue used during instantiation.
     */
    public void setUserValue(String userValue) throws JNCException {
        setUserValue(new YangString(userValue));
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "user" leaf will not have a value.
     */
    public void addUser() throws JNCException {
        setLeafValue(Simplelist.NAMESPACE,
            "user",
            null,
            childrenNames());
    }

    /* Access methods for optional leaf child: "group". */

    /**
     * Gets the value for child leaf "group".
     * @return The value of the leaf.
     */
    public YangString getGroupValue() throws JNCException {
        return (YangString)getValue("group");
    }

    /**
     * Sets the value for child leaf "group",
     * using instance of generated typedef class.
     * @param groupValue The value to set.
     * @param groupValue used during instantiation.
     */
    public void setGroupValue(YangString groupValue) throws JNCException {
        setLeafValue(Simplelist.NAMESPACE,
            "group",
            groupValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "group",
     * using a String value.
     * @param groupValue used during instantiation.
     */
    public void setGroupValue(String groupValue) throws JNCException {
        setGroupValue(new YangString(groupValue));
    }

    /**
     * Unsets the value for child leaf "group".
     */
    public void unsetGroupValue() throws JNCException {
        delete("group");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "group" leaf will not have a value.
     */
    public void addGroup() throws JNCException {
        setLeafValue(Simplelist.NAMESPACE,
            "group",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "group" with operation "replace".
     */
    public void markGroupReplace() throws JNCException {
        markLeafReplace("group");
    }

    /**
     * Marks the leaf "group" with operation "merge".
     */
    public void markGroupMerge() throws JNCException {
        markLeafMerge("group");
    }

    /**
     * Marks the leaf "group" with operation "create".
     */
    public void markGroupCreate() throws JNCException {
        markLeafCreate("group");
    }

    /**
     * Marks the leaf "group" with operation "delete".
     */
    public void markGroupDelete() throws JNCException {
        markLeafDelete("group");
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

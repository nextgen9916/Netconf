/* 
 * @(#)Ipv6AddressNoZone.java        1.0 16/08/17
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "ietf-inet-types", revision: "2013-07-15".
 */

package gen.com.example.test.inet.ietfInetTypes;

import com.tailf.jnc.YangException;

import gen.com.example.test.inet.ietfInetTypes.Ipv6Address;

/**
 * This class represents an element from 
 * the namespace 
 * generated to "src/gen/com/example/test/inet/ietfInetTypes/ipv6-address-no-zone"
 * <p>
 * See line 273 in
 * /home/tcs/Confd//src/confd/yang/ietf-inet-types.yang
 *
 * @version 1.0 2017-08-16
 * @author Auto Generated
 */
public class Ipv6AddressNoZone extends Ipv6Address {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for Ipv6AddressNoZone object from a string.
     * @param value Value to construct the Ipv6AddressNoZone from.
     */
    public Ipv6AddressNoZone(String value) throws YangException {
        super(value);
        check();
    }

    /**
     * Sets the value using a string value.
     * @param value The value to set.
     */
    public void setValue(String value) throws YangException {
        super.setValue(value);
        check();
    }

    /**
     * Checks all restrictions (if any).
     */
    public void check() throws YangException {
    }

}

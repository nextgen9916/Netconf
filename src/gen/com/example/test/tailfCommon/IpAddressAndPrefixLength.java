/* 
 * @(#)IpAddressAndPrefixLength.java        1.0 16/08/17
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "tailf-common", revision: "2017-03-08".
 */

package gen.com.example.test.tailfCommon;

import com.tailf.jnc.YangException;
import com.tailf.jnc.YangUnion;

/**
 * This class represents an element from 
 * the namespace 
 * generated to "src/gen/com/example/test/tailfCommon/ip-address-and-prefix-length"
 * <p>
 * See line 705 in
 * /home/tcs/Confd/src/confd/yang/tailf-common.yang
 *
 * @version 1.0 2017-08-16
 * @author Auto Generated
 */
public class IpAddressAndPrefixLength extends YangUnion {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for IpAddressAndPrefixLength object from a string.
     * @param value Value to construct the IpAddressAndPrefixLength from.
     */
    public IpAddressAndPrefixLength(String value) throws YangException {
        super(value,
            new String[] {
                "gen.com.example.test.tailfCommon.Ipv4AddressAndPrefixLength",
                "gen.com.example.test.tailfCommon.Ipv6AddressAndPrefixLength",
            }
        );
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

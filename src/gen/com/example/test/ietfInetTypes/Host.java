/* 
 * @(#)Host.java        1.0 16/08/17
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "ietf-inet-types", revision: "2013-07-15".
 */

package gen.com.example.test.ietfInetTypes;

import com.tailf.jnc.YangException;
import com.tailf.jnc.YangUnion;

/**
 * This class represents an element from 
 * the namespace 
 * generated to "src/gen/com/example/test/ietfInetTypes/host"
 * <p>
 * See line 408 in
 * /home/tcs/Confd/src/confd/yang/ietf-inet-types.yang
 *
 * @version 1.0 2017-08-16
 * @author Auto Generated
 */
public class Host extends YangUnion {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for Host object from a string.
     * @param value Value to construct the Host from.
     */
    public Host(String value) throws YangException {
        super(value,
            new String[] {
                "gen.com.example.test.ietfInetTypes.IpAddress",
                "gen.com.example.test.ietfInetTypes.DomainName",
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

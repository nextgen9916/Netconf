/* 
 * @(#)Ipv6FlowLabel.java        1.0 16/08/17
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "ietf-inet-types", revision: "2013-07-15".
 */

package gen.com.example.test.ietfInetTypes;

import com.tailf.jnc.YangException;
import com.tailf.jnc.YangUInt32;

/**
 * This class represents an element from 
 * the namespace 
 * generated to "src/gen/com/example/test/ietfInetTypes/ipv6-flow-label"
 * <p>
 * See line 106 in
 * /home/tcs/Confd/src/confd/yang/ietf-inet-types.yang
 *
 * @version 1.0 2017-08-16
 * @author Auto Generated
 */
public class Ipv6FlowLabel extends YangUInt32 {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for Ipv6FlowLabel object from a string.
     * @param value Value to construct the Ipv6FlowLabel from.
     */
    public Ipv6FlowLabel(String value) throws YangException {
        super(value);
        check();
    }

    /**
     * Constructor for Ipv6FlowLabel object from a long.
     * @param value Value to construct the Ipv6FlowLabel from.
     */
    public Ipv6FlowLabel(long value) throws YangException {
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
     * Sets the value using a value of type long.
     * @param value The value to set.
     */
    public void setValue(long value) throws YangException {
        super.setValue(value);
        check();
    }

    /**
     * Checks all restrictions (if any).
     */
    public void check() throws YangException {
    }

}

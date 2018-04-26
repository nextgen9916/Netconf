/* 
 * @(#)Conny.java        1.0 16/08/17
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "hosts", revision: "unknown".
 */

package gen.com.example.test.hosts;

import com.tailf.jnc.YangException;

import gen.com.example.test.hosts.Rej;

/**
 * This class represents an element from 
 * the namespace 
 * generated to "src/gen/com/example/test/hosts/conny"
 * <p>
 * See line 16 in
 * ../yang/hosts.yang
 *
 * @version 1.0 2017-08-16
 * @author Auto Generated
 */
public class Conny extends Rej {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for Conny object from a string.
     * @param value Value to construct the Conny from.
     */
    public Conny(String value) throws YangException {
        super(value);
        check();
    }

    /**
     * Constructor for Conny object from a long.
     * @param value Value to construct the Conny from.
     */
    public Conny(long value) throws YangException {
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

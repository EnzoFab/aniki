package business_logic;

import java.util.*;

/**
 * Permit to have a read only object and to hide some attribute
 */
public interface LightUser {

    /**
     * @return
     */
     String getMail();

    /**
     * @return
     */
     String getName();

    /**
     * @return
     */
     String getFirstName();

    /**
     * @return
     */
     String getPhone();

}
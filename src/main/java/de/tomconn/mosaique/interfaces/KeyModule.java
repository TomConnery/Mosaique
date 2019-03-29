package de.tomconn.mosaique.interfaces;


import javax.json.JsonStructure;

/**
 * A KeyModule contains code which shall be executed if a certain JSON key was encountered.
 *
 * @since 0.0.1
 */
public interface KeyModule<T extends JsonStructure > {


    /**
     * Called if this module was unregistered from a {@link Mosaique}
     * @param key the key under which this module was removed
     *
     * @since 0.0.1
     */
    void onUnregister(String key);

}

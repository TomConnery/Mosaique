package de.tomconn.mosaique.interfaces;

import de.tomconn.mosaique.interfaces.mosaique.MosaiqueBulkMethods;
import de.tomconn.web.annotation.HasBulk;

import java.util.*;

/**
 * <p>A Mosaique is a collection of {@link KeyModule KeyModules}.</p>
 * <p>Each module is associated a unique key.</p>
 *
 * @since 0.0.1
 */
public interface Mosaique {

    /**
     * Returns a {@link KeyModule} if there was one registered for the passed key
     *
     * @param key the key
     *
     * @return a module if one was present
     *
     * @since 0.0.1
     */
    @HasBulk
    Optional< KeyModule< ? > > getModuleForKey(String key);


    /**
     * Returns a list with keys the passed module is registered under.
     *
     * @param module the module for which you wish to get a list of keys it is registered under
     *
     * @return an {@link Optional} which contains a list of keys the passed module is registered under if, and only if,
     * the module is registered within this instance
     *
     * @see MosaiqueBulkMethods#getKeysForModules(Collection)
     * @since 0.0.1
     */
    @HasBulk
    Optional< List< String > > getKeysForModule(KeyModule< ? > module);


    /**
     * Registers a module for the passed key.
     *
     * @param key    the key for which the module shall be registered
     * @param module the module which shall be registered
     *
     * @return <p>true  - if, and only if, the module was successfully registered</p>
     * <p>false - if there was already a module present or the module could generally not be registered</p>
     *
     * @see MosaiqueBulkMethods#registerModulesForKeys(Map)
     * @since 0.0.1
     */
    @HasBulk
    boolean registerModuleForKey(String key, KeyModule< ? > module);


    /**
     * Unregisters a currently present key and returns the possibly placed module.
     *
     * @param key the key
     *
     * @return an {@link Optional} containing a module that was possibly registered under the passed key
     *
     * @see MosaiqueBulkMethods#unregisterKeys(Collection)
     * @since 0.0.1
     */
    @HasBulk
    Optional< KeyModule< ? > > unregisterKey(String key);


    /**
     * Unregisters a module
     *
     * @param module the module to unregister
     *
     * @return a {@link Optional} containing a {@link List} if, and only if, the module was registered under at least
     * one key, which contains all keys the module was registered under
     *
     * @see MosaiqueBulkMethods#unregisterModules(Collection)
     * @since 0.0.1
     */
    @HasBulk
    Optional< List< String > > unregisterModule(KeyModule< ? > module);


    /**
     * Forces the registration of a module by unregistering possible already present modules and registering the passed
     * module
     *
     * @param key    the key under which the module shall be registered
     * @param module the module
     *
     * @return <p>true  - if and only if the module was successfully registered</p>
     * <p>false - in all other cases, mainly because it was not possible to either unregister the present module or
     * register the passed module</p>
     *
     * @see MosaiqueBulkMethods#unregisterModules(Collection)
     * @since 0.0.1
     */
    @HasBulk
    boolean forceRegister(String key, KeyModule< ? > module);

}

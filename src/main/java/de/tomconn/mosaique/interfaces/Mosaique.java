package de.tomconn.mosaique.interfaces;

import de.tomconn.mosaique.interfaces.mosaique.MosaiqueBulkMethods;
import de.tomconn.mosaique.interfaces.mosaique.MosaiqueVarargMethods;
import de.tomconn.web.annotation.HasBulk;
import de.tomconn.web.annotation.HasVararg;
import de.tomconn.web.annotation.Single;

import javax.json.JsonObject;
import java.util.*;

/**
 * <p>A Mosaique is a mapping between {@link String}-based keys and {@link KeyModule KeyModules}.</p>
 * <p>Each module is associated a unique key.</p>
 *
 * @param <R></R> The return type of {@link #parse(JsonObject)}
 *
 * @since 0.0.1
 */
public interface Mosaique< R > {

    /**
     * Returns a {@link KeyModule} if there was one registered for the passed key
     *
     * @param key the key
     *
     * @return a module if one was present
     *
     * @see MosaiqueBulkMethods#getModulesForKeys(Collection)
     * @see MosaiqueVarargMethods#getModulesForKeys(String...)
     * @since 0.0.1
     */
    @HasBulk
    @HasVararg
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
     * @see MosaiqueVarargMethods#getKeysForModules(KeyModule[])
     * @since 0.0.1
     */
    @HasBulk
    @HasVararg
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
     * Unregisters a currently present key and returns the possibly under the key registered module.
     *
     * @param key the key
     *
     * @return <p>Either:</p>
     * <br>
     * <p>an {@link Optional} containing a module that was possibly registered under the passed key - if the passed key
     * was present</p>
     * <br>
     * or
     * <br>
     * <br>
     * <p><i>null</i> - if the passed key was <i>not</i> present</p>
     *
     * @see MosaiqueBulkMethods#unregisterKeys(Collection)
     * @see MosaiqueVarargMethods#unregisterKeys(String...)
     * @since 0.0.1
     */
    @HasBulk
    @HasVararg
    Optional< KeyModule< ? > > unregisterKey(String key);


    /**
     * Unregisters a module
     *
     * @param module the module to unregister
     *
     * @return <p>Either:</p>
     * <br>
     * <p>an {@link Optional} containing a {@link Collection} of keys under which the respective module was possibly
     * registered under  - if the module was registered at all</p>
     * <br>
     * or
     * <br>
     * <br>
     * <p><i>null</i> - if the module was <i>not</i> registered under any key</p>
     *
     * @see MosaiqueBulkMethods#unregisterModules(Collection)
     * @see MosaiqueVarargMethods#unregisterModules(KeyModule[])
     * @since 0.0.1
     */
    @HasBulk
    @HasVararg
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


    /**
     * <p>Parses the passed object and returns an instance of the specified return type.</p>
     *
     * @param object an instance of {@link JsonObject}
     *
     * @return an object of the return type
     *
     * @since 0.0.1
     */
    @Single
    R parse(JsonObject object);

}

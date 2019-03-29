package de.tomconn.mosaique.interfaces.mosaique;

import de.tomconn.mosaique.interfaces.KeyModule;
import de.tomconn.mosaique.interfaces.Mosaique;

import java.util.*;

/**
 * Defines bulk methods for {@link Mosaique}
 *
 * @since 0.0.1
 */
public interface MosaiqueBulkMethods {

    /**
     * Attempts to unregister the passed modules
     *
     * @param modules a {@link Collection} of {@link KeyModule KeyModules}
     *
     * @return <p>an {@link Optional} containing a {@link Map} if, and only if, at least one of the passed modules was
     * successfully unregistered.</p>
     * <p>The map contains mappings between a single {@link KeyModule} and a {@link List} of Strings under which the
     * module was registered.</p>
     * <p>Only modules which were unregistered are contained within the returned map.</p>
     *
     * @since 0.0.1
     */
    Optional< Map< KeyModule< ? >, List< String > > > unregisterModules(Collection< KeyModule< ? > > modules);


    /**
     * <p>Returns a map with the modules that are registered under the provided keys</p>
     *
     * @param keys a {@link Set} of keys
     *
     * @return <p>a {@link Map} with all keys and their {@link Optional} result</p>
     *
     * @see Mosaique#getModuleForKey(String)
     * @since 0.0.1
     */
    Map< String, Optional< List< KeyModule< ? > > > > getModulesForKeys(Set< String > keys);


    /**
     * Attempts to register the entries of the passed {@link Map}
     *
     * @param modules the modules and their keys
     *
     * @return a {@link Map} consisting of the respective return values of {@link Mosaique#registerModuleForKey(String,
     * KeyModule)} and the used key
     *
     * @see Mosaique#registerModuleForKey(String, KeyModule)
     * @since 0.0.1
     */
    Map< Boolean, String > registerModules(Map< String, KeyModule > modules);


    /**
     * <p>Calls {@link Mosaique#unregisterKey(String)} on each of the passed elements and returns </p>
     *
     * @param keys the keys
     *
     * @return a map of the keys and their respective results
     *
     * @see Mosaique#unregisterKey(String)
     * @since 0.0.1
     */
    Map< String, Optional< KeyModule > > unregisterKeys(Collection< String > keys);


}

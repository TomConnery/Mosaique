package de.tomconn.mosaique.api.mosaique;

import de.tomconn.mosaique.api.KeyModule;
import de.tomconn.mosaique.api.Mosaique;
import de.tomconn.web.annotation.HasSingle;
import de.tomconn.web.annotation.HasVararg;

import javax.json.JsonStructure;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * This interface contains all vararg-parameterized methods of {@link Mosaique}
 *
 * @param <M> the return type of {@link KeyModule#parse(JsonStructure)}
 *
 * @see Mosaique
 * @see HasVararg
 * @since 0.0.1
 */
public interface MosaiqueVarargMethods< M > {

    /**
     * <p>Returns a {@link Map} which contains key-{@link KeyModule} tuples.</p>
     * <p>Each key has an {@link Optional} associated to it.</p>
     * <p>All passed keys are present in the key set of the returned map.</p>
     *
     * @param keys the keys
     *
     * @return a map with all in the argument passed keys being present in the key set of the returned map
     *
     * @see Mosaique#getModuleForKey(String)
     * @since 0.0.1
     */
    @HasSingle
    Map< String, Optional< KeyModule< ?, M > > > getModulesForKeys(String... keys);


    /**
     * <p>Returns a {@link Map} which contains {@link KeyModule}-key tuples.</p>
     * <p>Each {@link KeyModule} in the passed vararg has an {@link Optional} associated to it.</p>
     * <p>The {@link Optional} <i>may</i> contain entries, depending on whether or not the respective module was
     * registered at all.</p>
     * <p>The resulting collection, if present, contains the keys under which the respective module is registered.</p>
     *
     * @param modules the modules for which the keys, under which the singular module is registered, shall be retrieved
     *                individually
     *
     * @return a mapping between the passed {@link KeyModule KeyModules} and the keys they're registered under
     *
     * @see Mosaique#getKeysForModule(KeyModule)
     * @since 0.0.1
     */
    @HasSingle
    Map< KeyModule< ?, M >, Optional< Collection< String > > > getKeysForModules(KeyModule< ?, M >... modules);


    /**
     * <p>Attempts to unregister each key present in the passed vararg.</p>
     *
     * @param keys a vararg of keys
     *
     * @return <p>A {@link Map} which contains <b>a subset</b> of the passed vararg as its key set.</p>
     * <p>The key set contains only those elements of the passed argument which were actually present when attempting
     * to unregister.</p>
     * <br>
     * <p>The keys of the map are each associated a possibly under the respective key registered {@link KeyModule} in
     * the form of an {@link Optional}.</p>
     *
     * @see Mosaique#unregisterKey(String)
     * @since 0.0.1
     */
    @HasSingle
    Map< String, Optional< KeyModule< ?, M > > > unregisterKeys(String... keys);


    /**
     * <p>Attempts to unregister each {@link KeyModule} present in the passed vararg.</p>
     *
     * @param modules a vararg of {@link KeyModule KeyModules}
     *
     * @return <p>A {@link Map} which contains <b>a subset</b> of the passed vararg as its key set.</p>
     * <p>The key set contains only those elements of the passed argument which were actually present when attempting
     * to unregister.</p>
     * <br>
     * <p>The keys of the map are each associated a possible {@link Collection} of keys under which the module was
     * registered in the form of an {@link Optional}.</p>
     *
     * @see Mosaique#unregisterModule(KeyModule)
     * @since 0.0.1
     */
    @HasSingle
    Map< KeyModule, Optional< String > > unregisterModules(KeyModule< ?, M >... modules);

}

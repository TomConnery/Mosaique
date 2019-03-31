package de.tomconn.mosaique.api;


import de.tomconn.web.annotation.Single;

import javax.json.JsonStructure;
import java.util.function.BiConsumer;

/**
 * A KeyModule contains code which shall be executed if a certain JSON key was encountered.
 *
 * @param <T> the subtype of {@link JsonStructure} which is expected to be passed
 * @param <R>
 *
 * @since 0.0.1
 */
public interface KeyModule< T extends JsonStructure, R > {


    /**
     * Called if this module was registered in a {@link Mosaique}
     *
     * @param key      the key under which this module was registered
     * @param mosaique the {@link Mosaique} in which this module was registered
     *
     * @since 0.0.1
     */
    @Single
    void fireRegister(String key, Mosaique< ?, ? extends T > mosaique);


    /**
     * Called if this module was unregistered from a {@link Mosaique}
     *
     * @param key      the key under which this module was removed
     * @param mosaique the {@link Mosaique} from which this module was removed
     *
     * @since 0.0.1
     */
    @Single
    void fireUnregister(String key, Mosaique< ?, ?  > mosaique);


    /**
     * <p>Registers a {@link BiConsumer} which is called upon firing the {@link #fireRegister(String, Mosaique)}
     * method.</p>
     *
     * @param consumer the consumer to register
     *
     * @since 0.0.1
     */
    @Single
    void onRegister(BiConsumer< String, Mosaique< ?, ?> > consumer);


    /**
     * <p>Registers a {@link BiConsumer} which is called upon firing the {@link #fireUnregister(String, Mosaique)}
     * method.</p>
     *
     * @param consumer the consumer to register
     *
     * @since 0.0.1
     */
    @Single
    void onUnregister(BiConsumer< String, Mosaique< ?, ? > > consumer);


    /**
     * Parses the passed element and returns an instance of the declared type
     *
     * @param struct an instance of the type set for {@code T}
     *
     * @return an instance of the set type for {@code R}
     *
     * @since 0.0.1
     */
    @Single
    R parse(T struct);

}

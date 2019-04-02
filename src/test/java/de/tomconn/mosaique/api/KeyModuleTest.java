package de.tomconn.mosaique.api;

import de.tomconn.mosaique.test_implementations.MosaiqueAdapter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <p>Tests the functionality of passed {@link KeyModule} instances.</p>
 *
 * @since 0.1.1
 */
public abstract class KeyModuleTest {

    private final Supplier<KeyModule<?, ?>> moduleSupplier;
    private final Random random = new Random(System.currentTimeMillis());
    private KeyModule<?, ?> instance;


    /**
     * The passed supplier must provide an indefinitely large amount of instances
     * @param moduleSupplier the supplier
     *
     * @since 0.1.1
     */
    protected KeyModuleTest(Supplier< KeyModule< ?, ? > > moduleSupplier) {

        this.moduleSupplier = moduleSupplier;
    }


    /**
     * Swaps the currently held instance for a new one
     *
     * @since 0.1.1
     */
    @BeforeEach
    @BeforeAll
    void swapInstance() {
        instance = moduleSupplier.get();
    }


    /**
     * Checks whether {@link KeyModule#onRegister(BiConsumer)} is correctly registering new consumers
     *
     * @since 0.1.1
     */
    @SuppressWarnings("unchecked")
    @Test
    void doesRegister_onRegister() {
        int amount = random.nextInt(9000) + 1000;
        BigInteger one = new BigInteger("1");
        BigInteger checksum = new BigInteger(String.valueOf(0));

        Collection<BiConsumer<String, Mosaique<?, ?>>> consumers = new ArrayList<>();

        for (int i = 0; i != amount; i++) {
            consumers.add((a1,a2) -> checksum.add(one));
        }

        consumers.forEach(c -> instance.onRegister(c));

        instance.fireRegister("Test run", new MosaiqueAdapter() {

        });

        assertEquals(amount, checksum.intValueExact());
    }




}

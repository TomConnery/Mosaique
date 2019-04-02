package de.tomconn.mosaique.test_implementations;

import de.tomconn.mosaique.api.KeyModule;
import de.tomconn.mosaique.api.Mosaique;

import javax.json.JsonObject;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>This class is a dummy implementation of {@link Mosaique}.</p>
 * <p>Do NOT use instances of this class for functionality testing!</p>
 *
 * <br>
 * <br>
 * <p>Usage example:</p>
 * <br>
 * <p>- use an anonymous class that extends this class and override single methods</p>
 *
 * @since 0.1.1
 */
public abstract class MosaiqueAdapter implements Mosaique {


    @Override
    public Optional< KeyModule > getModuleForKey(String key) {

        return Optional.empty();
    }


    @Override
    public Optional< KeyModule > unregisterKey(String key) {

        return Optional.empty();
    }


    @Override
    public Object parse(JsonObject object) {

        return null;
    }


    @Override
    public boolean forceRegister(String key, KeyModule module) {

        return false;
    }


    @Override
    public Optional< List< String > > unregisterModule(KeyModule module) {

        return Optional.empty();
    }


    @Override
    public boolean registerModuleForKey(String key, KeyModule module) {

        return false;
    }


    @Override
    public Optional< List< String > > getKeysForModule(KeyModule module) {

        return Optional.empty();
    }


    @Override
    public Optional< Map< KeyModule, List< String > > > unregisterModules(Collection collection) {

        return Optional.empty();
    }


    @Override
    public Map< String, Optional< List< KeyModule > > > getModulesForKeys(Collection keys) {

        return null;
    }


    @Override
    public Map< Boolean, String > registerModulesForKeys(Map modules) {

        return null;
    }


    @Override
    public Map< String, Optional< KeyModule > > unregisterKeys(Collection keys) {

        return null;
    }


    @Override
    public Map< KeyModule, Optional< List< String > > > getKeysForModules(Collection collection) {

        return null;
    }


    @Override
    public Map< String, Boolean > forceRegisters(Map map) {

        return null;
    }


    @Override
    public Map< String, Optional< KeyModule > > getModulesForKeys(String... keys) {

        return null;
    }


    @Override
    public Map< String, Optional< KeyModule > > unregisterKeys(String... keys) {

        return null;
    }


    @Override
    public Map< KeyModule, Optional< String > > unregisterModules(KeyModule[] modules) {

        return null;
    }


    @Override
    public Map< KeyModule, Optional< Collection< String > > > getKeysForModules(KeyModule[] modules) {

        return null;
    }

}

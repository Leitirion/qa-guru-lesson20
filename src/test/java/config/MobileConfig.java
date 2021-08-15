package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:local.properties"
})

public interface MobileConfig extends Config {

    @Key("browserstack.user")
    String getBrowserStackUser();

    @Key("browserstack.key")
    String getBrowserStackKey();

}
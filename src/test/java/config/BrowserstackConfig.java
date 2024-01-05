package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:data/androidData",
        "system:properties"
})
public interface BrowserstackConfig extends org.aeonbits.owner.Config {
    @Key("browserstackAccessKey")
    String getAccessKey();

    @Key("browserstackUserName")
    String getUserName();

    @Key("browserstackUrl")
    String getUrl();

    @Key("browserstackDevice")
    @DefaultValue("Google Pixel 3")
    String getDevice();

    @Key("browserstackOsVersion")
    @DefaultValue("9.0")
    String getOS();

    @Key("browserstackApp")
    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String getApp();
}
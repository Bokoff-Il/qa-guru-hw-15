package bokoff.il.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "classpath:${localOrRemote}.properties"
})
public interface WebConfig extends Config {

  @Key("browser")
  @DefaultValue("chrome")
  String browser();

  @Key("version")
  @DefaultValue("100.0")
  String version();

  @Key("host")
  String host();
}

package bokoff.il.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "file:secret.properties",
    "classpath:api.properties"
})
public interface ApiConfig extends Config {

  @Key("baseUri")
  @DefaultValue("http://github.com")
  String baseUri();

  @Key("token")
  @DefaultValue("de4hke23uizFh2f")
  String token();
}

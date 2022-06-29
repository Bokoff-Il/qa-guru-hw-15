package bokoff.il.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "file:secret.properties",
    "classpath:auth.properties"
})
public interface AuthConfig extends Config {

  @Key("username")
  String username();

  @Key("password")
  String password();
}

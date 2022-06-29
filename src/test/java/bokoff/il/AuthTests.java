package bokoff.il;

import static org.assertj.core.api.Assertions.assertThat;

import bokoff.il.config.AuthConfig;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

public class AuthTests {

  @Test
  public  void  testClassPath(){
    AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
    assertThat(config.username()).isEqualTo("ibokov");
    assertThat(config.password()).isEqualTo("1234");
  }

  @Test
  public  void  testLocalFile() throws IOException {

    String content = "username=secret-user\npassword=secret-password";

    Path propsPath= Paths.get("secret.properties");
    Files.write(propsPath, content.getBytes(StandardCharsets.UTF_8));

    AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
    assertThat(config.username()).isEqualTo("secret-user");
    assertThat(config.password()).isEqualTo("secret-password");

    Files.delete(propsPath);
  }

}

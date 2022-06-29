package bokoff.il;

import static org.assertj.core.api.Assertions.assertThat;

import bokoff.il.config.AndroidConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

public class AndroidTests {

  @Test
  public void testPropertiesFile(){
    AndroidConfig config = ConfigFactory.create(AndroidConfig.class, System.getProperties());
    assertThat(config.platformName()).isEqualTo("Android");
    assertThat(config.platformVersion()).isEqualTo("17.0");
    assertThat(config.deviceName()).isEqualTo("Google Pixel XL");
  }
}

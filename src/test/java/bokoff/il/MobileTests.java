package bokoff.il;

import static org.assertj.core.api.Assertions.assertThat;

import bokoff.il.config.AndroidConfig;
import bokoff.il.config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

public class MobileTests {

  @Test
  public void testAndroid(){
    System.setProperty("device", "pixel");
    MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

    assertThat(config.platformName()).isEqualTo("Android");
    assertThat(config.platformVersion()).isEqualTo("17.0");
    assertThat(config.deviceName()).isEqualTo("Google Pixel XL");
  }

  @Test
  public void testIphone12(){
    System.setProperty("device", "iphone12");
    MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

    assertThat(config.platformName()).isEqualTo("IOS");
    assertThat(config.platformVersion()).isEqualTo("14.0");
    assertThat(config.deviceName()).isEqualTo("iPhone 12 Pro Max");
  }
}

package bokoff.il;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bokoff.il.config.Browser;
import bokoff.il.config.TypesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

public class TypesTests {

  @Test
  public void testInteger() {
  System.setProperty("integer", "10");

    TypesConfig config = ConfigFactory.create(TypesConfig.class, System.getProperties());

    assertThat(config.getInteger()).isEqualTo(10);
  }

  @Test
  public void testDouble() {
    System.setProperty("double", "10.10");

    TypesConfig config = ConfigFactory.create(TypesConfig.class, System.getProperties());

    assertThat(config.getDouble()).isEqualTo(10.10);
  }

  @Test
  public void testEnum() {
    System.setProperty("enum", "CHROME");

    TypesConfig config = ConfigFactory.create(TypesConfig.class, System.getProperties());

    assertThat(config.getEnum()).isEqualTo(Browser.CHROME);
  }



}

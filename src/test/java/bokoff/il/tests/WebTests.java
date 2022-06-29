package bokoff.il.tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import bokoff.il.config.WebConfig;
import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;


//gradle clean test --tests WebTests -DlocalOrRemote=local запустится локально
//gradle clean test --tests WebTests -DlocalOrRemote=remote запустится удаленно

public class WebTests {

  @Test
  public void classpathLocalTest(){
    WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    Configuration.browser = config.browser();
    Configuration.browserVersion = config.version();
    if(config.host()!=null) {
      Configuration.remote = config.host();
    }

    open("https://github.com");
    $(".h1-mktg").shouldHave(text(" Where the world builds software "));

  }

}

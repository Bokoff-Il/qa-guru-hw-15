package bokoff.il;

import static org.junit.jupiter.api.Assertions.assertEquals;

import bokoff.il.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


public class SeleniumTest{

  private WebDriver driver = new WebDriverProvider().get();

  @Test
  public void testGitTitle() throws Exception{
    String title = driver.getTitle();
    Thread.sleep(5000);
    assertEquals(title,"GitHub: Where the world builds software · GitHub");
  }

  @AfterEach
  public void stopDriver(){
    driver.quit();
  }
}

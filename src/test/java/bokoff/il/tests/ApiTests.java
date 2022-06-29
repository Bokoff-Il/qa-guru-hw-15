package bokoff.il.tests;

import static io.restassured.RestAssured.given;

import bokoff.il.config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;


//gradle clean test --tests ApiTests -DbaseUri=https://reqres.in/ -Dtoken=QpwL5tke4Pnpja7X4 оба будут pass
public class ApiTests {

  @Test
  public void classpathLocalTest(){
    ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());

    RestAssured.baseURI=config.baseUri();

    String body = "{\"email\": \"eve.holt@reqres.in\",\"password\": \"pistol\"}";
    given()
        .body(body)
        .contentType(ContentType.JSON)
        .log().all()
        .when()
        .post("api/register")
        .then()
        .statusCode(200)
        .body("token", is(config.token()));
  }

  @Test
  public void classpathRemoteTest() throws IOException {
    String content = "baseUri=https://reqres.in/\ntoken=12345";//Тест упадет, тк токен не верный
    Path propsPath = Paths.get("secret.properties");
    Files.write(propsPath, content.getBytes(StandardCharsets.UTF_8));

    ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());
    RestAssured.baseURI = config.baseUri();

    String body = "{\"email\": \"eve.holt@reqres.in\",\"password\": \"pistol\"}";
    given()
        .body(body)
        .contentType(ContentType.JSON)
        .log().all()
        .when()
        .post("api/register")
        .then()
        .statusCode(200)
        .log().all()
        .body("token", is(config.token()));

    Files.delete(propsPath);
  }
}
package codeforfood;


import com.jayway.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PhotoGalleryApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
public class PhotoGalleryApplicationTests {


  @Value("${local.server.port}")
  int port;
  String folder;

  @Before
  public void setUp() {
    RestAssured.port = port;
  }

  @Test
  public void testPhotoGetRequest() {

    when().
            get("/photo").
    then().
            statusCode(HttpStatus.SC_OK);
  }

  @Test
  public void testPhotoPostRequest() {
    given().
            // delete 'G:\1' and enter your Path
            formParam("pathName", "G:\\1").
            when().
            post("/photo").
            then().
            statusCode(HttpStatus.SC_OK).
            body("name", Matchers.is("20"));
  }

  @Test
  public void testPhotoBlackbackground() {

    when().
            get("/photo/blackbackground").
            then().
            statusCode(HttpStatus.SC_OK);
  }
  @Test
  public void testPhotoOriginal() {

    when().
            get("/photo/original").
            then().
            statusCode(HttpStatus.SC_OK);
  }
  @Test
  public void testAspectRatio() {
    given().
            pathParam("string", "50x150").
    when().
            post("/photo/wh/{string}").
            then().
            statusCode(HttpStatus.SC_OK);
  }
  @Test
  public void testPhotoRow() {
    given().
            pathParam("row", "7").
    when().
            get("/photo/row/{row}").
            then().
            statusCode(HttpStatus.SC_OK);
  }


}
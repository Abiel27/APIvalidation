package APItest;
import static io.restassured.RestAssured.*;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
public class deletManuellyWithRest {
    @BeforeClass
    public void justcollect() {
        baseURI = "http://3.238.143.111:8000";}
        /* different ways to send json data
- String
-using collection (Map)
-POJO

 */


        @Test
        public void deletWithRest(){
            given().pathParam("id", 128)
                    .when().delete("/api/spartans/{id}")
                    .then().assertThat().statusCode(204);

            // Verify the given id is deleted!
            given().pathParam("id", 128)
                    .when().delete("/api/spartans/{id}")
                    .then().assertThat().statusCode(404);

        }
    }

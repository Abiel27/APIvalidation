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

public class putRequestWithRest {
    @BeforeClass
    public void justcollect() {
        baseURI = "http://3.238.143.111:8000";
    }
/* different ways to send json data
- String
-using collection (Map)
-POJO

 */
    @Test
    public void pojoDeserialization() {
        // using Map
        Map<String,Object> putRahiteyMap= new HashMap<>();
        putRahiteyMap.put("name","Rahwitey");
        putRahiteyMap.put("gender","Female");
        putRahiteyMap.put("phone",2029096292);
                given().contentType(ContentType.JSON)
                .and().pathParam("id", 105)
                .and().body(putRahiteyMap)
                .when().put("/api/spartans/{id}")
               .then().assertThat().statusCode(204);
       // System.out.println("Shikorina = " + putRahiteyMap.toString());
    }
}
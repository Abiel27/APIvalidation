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
public class patchRequestToEdit {
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
public void pojoPatchEditJson() {
    // using Map
    Map<String,Object> patchRahiteyMap= new HashMap<>();
    patchRahiteyMap.put("name","RahwitXibikti");

    given().contentType(ContentType.JSON)
            .and().pathParam("id", 105)
            .and().body(patchRahiteyMap)
            .when().patch("/api/spartans/{id}")
            .then().assertThat().statusCode(204);
    // System.out.println("Shikorina = " + putRahiteyMap.toString());
}
}


package APItest;
import static io.restassured.RestAssured.*;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import java.util.HashMap;
import java.util.Map;
public class jsonSchemaValidator {
    @BeforeClass
    public void justcollect() {
        baseURI = "http://3.238.143.111:8000";
    }
    @Test
    public void jsonValidationTest(){
        given().contentType(ContentType.JSON)
                .and().pathParam("id",105)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().body(matchesJsonSchemaInClasspath("singlespartanJsonValidator.json"));
    }
}

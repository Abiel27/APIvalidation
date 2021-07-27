package APItest;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;


public class DeserialiationJsontoJava {
    @BeforeClass
    public void justcollect() {
        baseURI = "http://3.238.143.111:8000";
    }/*Accept contentType Json
 given path parameter
when send get request to "/api/spartans/{is}
 contentType should be "application/json"
and response paylaod should match the the following value
    {
    "id": 102,
    "name": "Abiel",
    "gender": "Male",
    "phone": 2029096292

 */
    @Test
    public void deserialisationJsonToJavaCollection(){
        //request
            Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 103)
                .when().get("/api/spartans/{id}");

             // Convert Json to Java collection, Deserialization

       Map<String,Object> desiredMapOfSpartan= response.body().as(Map.class);
        System.out.println("name = " + desiredMapOfSpartan.get("name"));
        System.out.println("id = " + desiredMapOfSpartan.get("id"));

        //Verify name by asserting it which is already converted in key and value format.
        Assert.assertEquals(desiredMapOfSpartan.get("name"),"Rahwa");

    }

}

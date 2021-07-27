package APItest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class parameterID {
    //Given accept type is json
    //ID paramenter value is 101
    //when use sent get request to "/api/spartans/{id}
    //then response status code is 200
    //and contentType is : application/json
    //and body contains "Abiel"
    @BeforeClass
    public void setUpClass() {
        RestAssured.baseURI = "http://3.238.143.111:8000";
    }
    @Test
    public void withParameterPathID(){
      Response response= RestAssured.given().accept(ContentType.JSON).and().pathParam("id", 101)
                .when().get("/api/spartans/{id}");
      //assert status code 200
       // assertEquals(response.statusCode(),200);
        // assert contentType json
        assertEquals(response.contentType(),"application/json");
        //assert body contains "Abiel"
        assertTrue(response.body().asString().contains("Abiel"));
       response.body().prettyPrint();

    }
    //given accept type is JSON
    //when user send get request to //api/spartans/{id}
    //then response status code should be 404
    //and response content type: application/json;charset=UTF-8
    //and "spartan not found" message should be desplayed
    @Test
    public void negativePathTestResponse(){
        Response response=RestAssured.given().accept(ContentType.JSON).pathParam("id",1000).when()
                .get("/api/spartans/{id}");
        //assert status code
        assertEquals(response.statusCode(),404);
        // assert content type application/json;charset=UTF-8
        assertEquals(response.contentType(),"application/json");
        //assert body and print empty string " "
      assertTrue(response.body().asString().contains(" "));
        response.prettyPrint();

    }
}

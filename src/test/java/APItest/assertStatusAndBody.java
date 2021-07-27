package APItest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class assertStatusAndBody {
    String spartanBaseURL = "http://3.238.143.111:8000";

    @Test

    public void singleSpartan(){

        Response response= RestAssured.get(spartanBaseURL + "/api/spartans");

        //This how to read status code and body.
        System.out.println(response.statusCode());
      System.out.println(response.body().prettyPrint());

    }
    @Test
    public void assertStatus_BodyContains(){
       Response response= RestAssured.get(spartanBaseURL + "/api/spartans");

       // assert the statuse code is 200
        Assert.assertEquals(response.statusCode(),200);
        // assert the body contains Abiel
        Assert.assertTrue(response.body().asString().contains("Abiel"));
        //assert that the body contains fidole
        Assert.assertTrue(response.body().asString().contains("Fidole"));

    }
    //Given accept tpe is Jyson
    //when get request to spartanBaseURL
    //response status code is 200
    //response body is json format
    @Test
    public void assertHeaderContentTypeIsJson(){
       Response response= RestAssured.given().accept(ContentType.JSON)
                .when().get(spartanBaseURL+"/api/spartans");
       //status code
       Assert.assertEquals(response.statusCode(),200);
       // response Json format
        Assert.assertEquals(response.contentType(),"application/json");
    }

}




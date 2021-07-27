package APItest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class queryParameterSparta {
    @BeforeClass
    public void setUpClass() {
       RestAssured.baseURI = "http://3.238.143.111:8000";
    }
    //Given accept content type JSON
    //and query parameter value are: gender/Female , name contains/e
    //when user send get request tp : api/spartans/search
    //Then response status code should be 200
    //and response content-Type : application/json
    //and "female" should be in the response body
    //and "jannete'' should be in the response paylaod
    @Test
    public void queryPathTest(){
     Response response =  RestAssured.given().accept(ContentType.JSON)
               .and().queryParam("gender","Female")
               .and().queryParam("nameContains","J")
               .when().get("/api/spartans/search");
       //verify status code
        //Assert.assertEquals(response.statusCode(),200);

        //contenttype assertion
       Assert.assertEquals(response.contentType(),"application/json" );
        // verify Female
        Assert.assertTrue(response.body().asString().contains("Female"));
        //verify the the body contains male.
       Assert.assertFalse(response.body().asString().contains("Male"));
        // verify the paylaod contains Jannete
       Assert.assertTrue(response.body().asString().contains("Jennica"));
       response.prettyPrint();
    }
    @Test
    public void querParamMap(){
        Map<String,Object> queryParam = new HashMap<>();
        queryParam.put("gender","Female");
        queryParam.put("nameContains","J");

        //send request
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParams(queryParam)
                .when().get("/api/spartans/search");
        //contenttype assertion
        Assert.assertEquals(response.contentType(),"application/json" );
        // verify Female
        Assert.assertTrue(response.body().asString().contains("Female"));
        //verify the the body contains male.
        Assert.assertFalse(response.body().asString().contains("Male"));
        // verify the paylaod contains Jannete
        Assert.assertTrue(response.body().asString().contains("Jennica"));
        response.prettyPrint();

    }
}

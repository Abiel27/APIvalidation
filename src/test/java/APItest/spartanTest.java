package APItest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.Test;

public class spartanTest {
    String spartanBaseURL = "http://3.238.143.111:8000";

    @Test

    public void singleSpartan(){

       Response response= RestAssured.get(spartanBaseURL + "/api/spartans");

        System.out.println(response.statusCode());
        System.out.println(response.body().prettyPrint());

    }


}
//This how to read status code and body.

package APItest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class easyWayCoding {
    @BeforeClass
    public void justcollect() {
        RestAssured.baseURI = "http://3.238.143.111:8000";
    }

    @Test
    public void getThelistOfNamesAndPhone() {
        Response response = RestAssured.get("/api/spartans");

        //retrieve the names and print them

        List<String> names = response.path("name");
        for (String name : names) {
            System.out.println(name);


            }
        }
    }






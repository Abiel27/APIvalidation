package APItest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class getTheList {
    String URL = "http://3.238.143.111:8000";

    @Test
    public void theList(){
       Response response = RestAssured.get(URL+"/api/spartans");

       //get the names of the web list
//        List<String> names=response.path("name");
//        for (String name : names) {
//           System.out.println(names.size());

           List<Object> phoneNumber = response.path("phone");
            for (Object phones : phoneNumber) {
                System.out.println("phones = " + phones);
            }
        }
        }


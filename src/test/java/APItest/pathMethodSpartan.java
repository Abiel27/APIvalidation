package APItest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class pathMethodSpartan {
    @BeforeClass
    public void setUpClass() {
        RestAssured.baseURI = "http://3.238.143.111:8000";
    }
    //Accept contentType Json
    // given path parameter
    //when send get request to "/api/spartans/{is}
    // contentType should be "application/json"
    //and response paylaod should match the the following value
    /*
    {
    "id": 102,
    "name": "Abiel",
    "gender": "Male",
    "phone": 2029096292
}
     */
    @Test
    public void pathParameterSparta(){
       Response response= RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id",2)
                .when().get("/api/spartans/{id}");
        //assert status code
       Assert.assertEquals(response.statusCode(),200);
        //assert contentType
        Assert.assertEquals(response.contentType(),"application/json");
        //verify and print the body value, printing json key and value
        System.out.println("id " + response.body().path("id").toString());
        System.out.println("name " + response.body().path("name").toString());
        System.out.println("gender "+response.body().path("gender").toString());
        System.out.println("phone "+response.body().path("phone").toString());

        int id = response.path("id");
        String name=response.body().path("name");
        String gender= response.body().path("gender");
        long phone = response.body().path("phone");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        // verify json key and value
        Assert.assertEquals(id,2);
        Assert.assertEquals(name,"Nels");
        Assert.assertEquals(gender,"Male");
        Assert.assertEquals(phone,4218971348l);

    }
    @Test
    public void pathMethodMultiple(){
       Response response= RestAssured.get("/api/spartans");

        //retrieve data use path json
        int first1stID = response.path("id[1]");
        System.out.println("first1stID = " + first1stID);

        String firstName = response.path("name[1]");
        System.out.println("firstName = " + firstName);

        // get the last second name
        String lastsecondName = response.path("name[-4]");
        System.out.println("lastsecondName = " + lastsecondName);

        // extract all first name and print,
        List<String> names = response.path("name");
        System.out.println("names = " + names.size());
        //print all numbers
       List<Object> phoneNumbers = response.path("phone");
        for (Iterator<Object>  iterator = phoneNumbers.iterator();   iterator.hasNext(); ) {
            Object next =  iterator.next();
            System.out.println( next);
        }

        }



}

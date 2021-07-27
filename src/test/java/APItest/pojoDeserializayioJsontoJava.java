package APItest;
import static io.restassured.RestAssured.*;

import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class pojoDeserializayioJsontoJava {
    @BeforeClass
    public void justcollect() {
        baseURI = "http://3.238.143.111:8000";
    }
    @Test
    public void pojoDeserialization(){
       Response response = given().accept(ContentType.JSON)
                .and().pathParam("id",103)
                .when().get("/api/spartans/{id}");
        //response.prettyPrint();

        // Gson deserialization
        //convert Json to my class wwhich is Java

        spartan spartan1 = response.body().as(spartan.class);
        //System.out.println("spartan = " + spartan1.getName());
        //System.out.println("spartan1 = " + spartan1);

        //assert the given above
        Assert.assertEquals(spartan1.getId(),103);
        Assert.assertEquals(spartan1.getName(),"Rahwa");
        Assert.assertEquals(spartan1.getGender(),"Male");
        Assert.assertEquals(spartan1.getPhone(),2029096292l);

    }
    @Test
    public void TestUsingGsonToconvertJsonTo(){
        Gson gson = new Gson();
        String JsonBody = "{\n" +
                "    \"id\": 103,\n" +
                "    \"name\": \"Rahwa\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"phone\": 2029096292\n" +
                "}";
        spartan jsonBody103 = gson.fromJson(JsonBody,spartan.class);

        System.out.println("oneOthree = " + jsonBody103.toString());

        //serialization from java to json structure
        spartan spartan2= new spartan(103,"Rahwa","Male",2029096292l);
        //using the gson object , i can change java to json
        String jsonBody103Male= gson.toJson(spartan2);
        System.out.println("jsonBody103Male = " + jsonBody103Male);
    }
}

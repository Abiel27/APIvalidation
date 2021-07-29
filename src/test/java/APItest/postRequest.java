package APItest;

import static io.restassured.RestAssured.*;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class postRequest {
    @BeforeClass
    public void justcollect() {
        baseURI = "http://3.238.143.111:8000";
    }
    /* Given accept type and content type is json
    THE request Json body is:
    {
  "gender": "Female",
  "name": "Rahwiti",
  "phone": 2029096292
}
whe user sent post request to '/sparatn'
then status code 201
and content type shoild be application/json
and json payload/response should contain:
"spartan is born!" and same data what is poseted

     */
    @Test
    public void postrequestSpartan(){
        //sending json body as a string,
       Response response= given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"gender\": \"Female\",\n" +
                        "  \"name\": \"Rahwiti\",\n" +
                        "  \"phone\": 2029096292\n" +
                        "}")
                .when().post("/api/spartans");
      // response.prettyPrint();
        //verify or asset the status and content

        Assert.assertEquals(response.statusCode(),201);
        Assert.assertEquals(response.contentType(),"application/json");

        //verify request body
       JsonPath jsonPathToVerify = response.jsonPath();

       Assert.assertEquals(jsonPathToVerify.getString("data.name"),"Rahwiti");
       Assert.assertEquals(jsonPathToVerify.getString("data.gender"),"Female");
       //Assert.assertEquals(jsonPathToVerify.getString("data.phone"),2029096292L);

    }
    @Test
    public void postRequestMapAsKeyValue(){
        Map<String,Object> postRequestInMap= new HashMap<>();
        postRequestInMap.put("name","RahwitiAbielMen");
        postRequestInMap.put("gender","Female");
        postRequestInMap.put("phone",2029096292L);

        Response response= given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(postRequestInMap)
                .when().post("/api/spartans");

        Assert.assertEquals(response.statusCode(),201);
        response.prettyPrint();



    }
    @Test// in this test I learn serialization and deserialization
    public void postRequestWithPOJO(){
        spartan spartan128= new spartan();
        spartan128.setName("RahwaAbielPOjo");
        spartan128.setGender("Female");
        spartan128.setPhone(2029096292);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(spartan128)
                .when().post("/api/spartans");

        Assert.assertEquals(response.statusCode(),201);
        Assert.assertEquals(response.contentType(),"application/json");

        response.prettyPrint();

       // ----------------------Get request------------------
       Response response2= given().accept(ContentType.JSON)
                .and().pathParam("id",128)
                .when().get("/api/spartans/{id}");
       spartan spartant128respons=response2.body().as(spartan.class);

        System.out.println("BurtiMariamBurukFireKersiki"+spartant128respons.toString());



    }
}

package APItest;

import com.fasterxml.jackson.core.json.PackageVersion;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class JsonPathChainingAssertingMultiMap {
    @BeforeClass
    public void justcollect() {
        RestAssured.baseURI = "http://3.238.143.111:8000";
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
    public void pathParameterSparta() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 103)
                .when().get("/api/spartans/{id}");

        //Assert te statuse code
        Assert.assertEquals(response.statusCode(),200);
        //read value with path method
        int id = response.path("id");
        System.out.println("id = " + id);
        //read value with jsonpath
        io.restassured.path.json.JsonPath jsonData = response.jsonPath();

       int id1 = jsonData.getInt("id");
       String name1= jsonData.getString("name");
       String gender1 = jsonData.getString("gender");
       long phone = jsonData.getLong("phone");
       //print one by one
        System.out.println(" id1= " + id);
        System.out.println("name1 = " + name1);
        System.out.println("gender1 = " + gender1);
        System.out.println("phone1 = " + phone);

       //verify json body with json path
        Assert.assertEquals(id,103);
        Assert.assertEquals(name1,"Rahwa");
        Assert.assertEquals(gender1,"Male");
        Assert.assertEquals(phone,2029096292L);

    }
    @Test
    public void serialzationMultipleNameInMap(){
       Response response= RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans");
        //Print for checking
        //response.prettyPrint();
        //deserialization- many names, first to the list then create a map structure
        List<Map<String,Object>> listOfSpartanNames = response.body().as(List.class);

        // now we can print the first punch of Json structure, from the list.
       System.out.println( listOfSpartanNames.get(0));

        Map<String,Object> firstPunchJson= listOfSpartanNames.get(102);
        System.out.println(firstPunchJson.get("name"));

        // retrieve all the list as a serial number.
        int counter = 0;
        for (Map<String, Object> mapOfTheListOneByOne : listOfSpartanNames) {
            System.out.println(counter+"-Is = " + mapOfTheListOneByOne);
            counter++;


        }

    }
}
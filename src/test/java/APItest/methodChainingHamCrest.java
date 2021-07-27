package APItest;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class methodChainingHamCrest {
    @BeforeClass
    public void justcollect() {
       baseURI = "http://3.238.143.111:8000";
}/*Accept contentType Json
 given path parameter
when send get request to "/api/spartans/{is}
 contentType should be "application/json"
and response paylaod should match the the following value
    {
    "id": 103,
    "name": "Rahwa",
    "gender": "Male",
    "phone": 2029096292

 */
    @Test
    public void methodChainHamcrest(){
                //request
                   given().accept(ContentType.JSON)
                .and().pathParam("id",103)
                .and().when().get("api/spartans/{id}")
                           //Response
                            .then().statusCode(200).and()
                           .assertThat().contentType("application/json");

    }
    @Test
    public void TestWithHamCrestChain(){
        //request
        given().accept(ContentType.JSON)
                .and().pathParam("id",103)
                .when().get("api/spartans/{id}")
                //Response
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .assertThat().body("id", Matchers.equalTo(103),
                "name",Matchers.equalTo("Rahwa"),
                "gender",Matchers.equalTo("Male"),"phone",Matchers.equalTo(2029096292));
    }
}

package secondPhase2;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import test_Utililies.spartanNoAuthtestBaseclass;

import javax.annotation.Resource;

public class PathAndQueryVariablespartans extends spartanNoAuthtestBaseclass{
    @Disabled("Spartan test with path variable")
    @Test
    public void pathVariableTest(){
       // get("/spartans/120").prettyPeek();
       Response res1 = given().contentType(ContentType.JSON)
                .pathParam("id",120)
                .when().get("/spartans/{id}").prettyPeek();

        //Alternative
        Response res2= given().accept("application/json")
                .when().get("/spartans/{id}",120).prettyPeek();
    }
}

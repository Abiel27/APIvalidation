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

public class queryPathSparta extends spartanNoAuthtestBaseclass {
   @Disabled("Query param request")
        @Test
    public void queryParamRequesst(){
     Response response=  given().log().all()
               .queryParam("nameContains","RahwitiAbiel")
               .queryParam("gender","Female")
               .when().get("/spartans/search").prettyPeek();
       //Assert the totalElements
       System.out.println("response.path(\"totalElement\") = " + response.path("totalElement"));


   }
}

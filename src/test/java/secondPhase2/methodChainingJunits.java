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
public class methodChainingJunits extends spartanNoAuthtestBaseclass {
    @Disabled("method vhaining")
    @Test
    public void methodchainingJunit5(){
        enableLoggingOfRequestAndResponseIfValidationFails();
        given().log().all().pathParam("id",120)
                .when().get("/spartans/{id}")
                .then().log().all().statusCode(200)
                .header("content-Type","application/json")
                .body("id",equalTo(120))
                .body("name",is("RahwitiAbiel"))
                .body("gender",equalTo("Female"))
                .body("phone",equalTo(2029096292));
    }
}

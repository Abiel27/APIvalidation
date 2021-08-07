package secondPhase2;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import test_Utililies.breakingBadBaseclass;

public class breakingBadTest extends breakingBadBaseclass {
    @Disabled("Get /characters with query name")
    @Test
    public void breakingBadTest() {
        given().queryParam("name", "Walter")
                .when().get("/characters")
                .then().log().all().statusCode(200)
                .contentType("application/json; charset=utf-8");

    }

    @Disabled("Test Get /charachter/{id}")
    @Test
    public void test1charachter() {
        given().pathParam("char_id", 1)
                .log().uri()
                .when().get("/charachters/{char_id}")
                .then().log().all().statusCode(200)
                .header("Content-Type", "text/html; charset=UTF-8")
                .contentType("application/json; charset=utf-8");
    }

    ///api/episodes/60
    @Disabled("Test Get /episodes/{id}")
    @Test
    public void test1Episode() {
        //Request
        given().pathParam("episodes id",160)
                .log().all()
                //response
                .when().get("/episodes/{episodes id}")
                //validation
                .then().statusCode(200)
                .contentType(ContentType.JSON);


    }
}
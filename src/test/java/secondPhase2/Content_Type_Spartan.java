package secondPhase2;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import test_Utililies.spartanNoAuthtestBaseclass;

@DisplayName("ContentType-Test")
public class Content_Type_Spartan extends spartanNoAuthtestBaseclass {
    @DisplayName("Get /hello")
    @Test
    public void testHellocontentType(){
        when().get("/hello")
                .then().contentType(ContentType.TEXT);
    }
    @DisplayName("Get /Spartans")
    @Test
    public void getJsonContentTypeSpartans(){
        //Request in Json
        given().accept(ContentType.JSON)
                .when().get("/spartans")
                .then().contentType(ContentType.JSON);
    }
    @DisplayName("Get /Spartans in xml")
    @Test
    public void testSpartansInxml(){
        //Request in .xml
        given().accept(ContentType.XML)
                //Respons
                .when().get("/spartans")
                //validation
                .then().contentType(ContentType.XML);


    }
}


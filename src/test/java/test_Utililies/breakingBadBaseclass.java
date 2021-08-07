package test_Utililies;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public abstract class breakingBadBaseclass {


        //https://www.breakingbadapi.com/api/characters?name=Walter
        @Disabled("breaking bad test")
        @BeforeAll
        public static void beforeallInIt(){
            baseURI= "https://www.breakingbadapi.com";
            basePath = "/api";

        }
        @AfterAll
        public static void resetAfterAllCharachterName(){

        }
}

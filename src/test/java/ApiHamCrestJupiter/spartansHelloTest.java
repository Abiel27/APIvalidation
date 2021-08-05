package ApiHamCrestJupiter;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import test_Utililies.spartanNoAuthtestBaseclass;

@Disabled("Spartans hello test")
public class spartansHelloTest extends spartanNoAuthtestBaseclass {


    @Test
    public void helloSpartanTest(){
        get("/hello").prettyPeek();
    }
    @Test
    public void getAllSpartans(){
        get("/spartans").prettyPeek();
    }

    }






package ApiHamCrestJupiter;

import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchers {
    @Test
    public void hamcrestMakeEasy(){
        // equal
        String king= "Abiel Menghistu is surviver";

        assertThat(10, Matchers.is(5 + 5));
        assertThat(king,equalTo("Abiel Menghistu is surviver"));
        assertThat(king,is(equalTo("Abiel Menghistu is surviver")));
        assertThat(king,startsWith("A"));
        assertThat(king,startsWithIgnoringCase("abiel"));
        assertThat(king,endsWith("surviver"));
        assertThat(king,containsString("is"));

        String str = " ";
        //first trim
        assertThat(str.trim(),emptyString());

    }
    @DisplayName("Collection")
    @Test
    public void testingListOfCollection(){
        List<Integer> num = Arrays.asList(1,2,3,4,5,6);
        //check
        assertThat(num,hasSize(6));



    }@DisplayName("testng hello end point")
    @Test
    public void restassuredIntro(){
       Response response= get("http://3.238.143.111:8000/api/hello");

        System.out.println("response.getTime() = " + response.getTime());


    }
@DisplayName("Spartans/{id}")
    @Test
    public void getRequestTest(){


        Response response = get("http://3.238.143.111:8000/api/spartans/105").prettyPeek();
        assertThat(response.statusCode(),is(equalTo(200)));
        assertThat(response.contentType(),is(equalTo("application/json")));
        assertThat(response.header("connection"),is(equalTo("keep-alive")));
        //json body
    System.out.println("response.path(\"id\") = " + response.path("id"));
    System.out.println("response.path(\"name\") = " + response.path("name"));
    System.out.println("response.path(\"gender\") = " + response.path("gender"));
    System.out.println("response.path(\"phone\") = " + response.path("phone"));

    // Giving spesific data type(to store the response in a unique variable)
    int myid = response.path("id");
    String myname  =response.path("name");
   // Long myPhone = response.path("phone");

    System.out.println("myid = " + myid);
    System.out.println("myname = " + myname);
    //System.out.println("myPhone = " + myPhone);

}




}


        /*System.out.println("response = " + response.statusCode());
        System.out.println("response.getHeader(\"Content-Type\") = " + response.getHeader("Content-Type"));

        System.out.println("response.asString() = " + response.asString());
        assertThat(response.statusCode(),is(200));
        System.out.println("response.getContentType() = " + response.getContentType());
        assertThat(response.contentType(),startsWith("text/plain"));
        assertThat(response.asString(),is("Helo from Sparta"));
        //System.out.println("response.getTime() = " + response.getTime());
*/

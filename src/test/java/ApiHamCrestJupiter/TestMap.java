package ApiHamCrestJupiter;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hamcrest.collection.IsMapContaining;

import static io.restassured.RestAssured.baseURI;

public class TestMap {
    @BeforeClass
    public void justcollect() {
        baseURI = "http://3.238.143.111:8000";
    }
    @Test

    public void testmap(){

        Map<String, Integer> map = Stream.of(new Object[][] {
                { "data1", 1 },
                { "data2", 2 },
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Matchers.hasKey(\"data1\") " + Matchers.hasKey("data1").matches("data1"));
            System.out.println("Matchers.hasValue(1) " + Matchers.hasValue(1).matches(1));
            System.out.println("IsMapContaining.hasKey(\"data1\") " + IsMapContaining.hasKey("data1").matches("data1"));
            System.out.println("IsMapContaining.hasValue(1) " + IsMapContaining.hasValue(1).matches(1));
            System.out.println("IsMapContaining.hasEntry(entry.getKey(), entry.getValue()) " + IsMapContaining.hasEntry(entry.getKey(), entry.getValue()));
        }
    }
}

package ApiHamCrestJupiter;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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



    }

}


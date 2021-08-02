package ApiHamCrestJupiter;

import org.junit.jupiter.api.*;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Api with Junit Jupiter annotation")

public class Junit5test {
    @BeforeAll
    public static void beforeAllInIt(){
        System.out.println("Before all ");
    }
    @AfterAll
    public static void afterAllInIt(){
        System.out.println("This part is printed after all");

    }
    @BeforeEach
    public void beforeEachInit(){
        System.out.println("Before each is running");
    }
    @AfterEach
    public void initAfterEach(){
        System.out.println("Before each is running");
    }
    @Test
    public void jupiterTest(){
        System.out.println("Rest IsFunn");

        assertEquals(1,1);

    }
    @DisplayName("SecondLevel")
    // Asser the name contains Alphabet "A"
    @Disabled
    @Test
    public void testName(){
        String King= "Abiel";
        assertEquals('A',King.charAt(0));
        assertTrue(King.startsWith("A"));
        System.out.println(King);

    }
}
/* This is the out put,
Before all
Before each is running
Before each is running
Before each is running
Rest IsFunn
Before each is running
This part is printed after all
 */
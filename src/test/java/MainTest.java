import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void it_solves_example() {
        provideInput("2\n" +
                "5 5\n" +
                "4 0 4 4\n" +
                "1\n" +
                "1 4 2 3\n" +
                "3 3\n" +
                "0 0 2 2\n" +
                "2\n" +
                "1 1 0 2\n" +
                "0 2 1 1");

        Main.main(new String[0]);

        String result = getOutput();
        assertEquals("Optimal solution takes 7 hops.\n" +
                "No solution.\n", result);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

}

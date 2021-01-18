import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    private final InputStream systemIn = System.in;

    private ByteArrayInputStream testIn;

    @Test
    public void it_parses_example() {
        provideInput("5 5\n" +
                "4 0 4 4\n" +
                "1\n" +
                "1 4 2 3");

        Scanner sc = new Scanner(System.in);

        Grid grid = Parser.parseGrid(sc);

        assertEquals(5, grid.width);
        assertEquals(5, grid.height);
        assertEquals(4, grid.start.x);
        assertEquals(0, grid.start.y);
        assertEquals(4, grid.end.x);
        assertEquals(4, grid.end.y);
        assertEquals(1, grid.obstacles.size());
        Obstacle obstacle = grid.obstacles.get(0);
        assertEquals(1, obstacle.p1.x);
        assertEquals(2, obstacle.p1.y);
        assertEquals(4, obstacle.p2.x);
        assertEquals(3, obstacle.p2.y);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}

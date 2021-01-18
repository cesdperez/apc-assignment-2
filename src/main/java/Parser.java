import java.util.LinkedList;
import java.util.Scanner;

public class Parser {

    public static Grid parseGrid(Scanner sc) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int endX = sc.nextInt();
        int endY = sc.nextInt();

        int p = sc.nextInt();
        LinkedList<Obstacle> obstacles = new LinkedList<>();
        for (int j = 0; j < p; j++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y1 = sc.nextInt();
            int y2 = sc.nextInt();
            obstacles.add(new Obstacle(new Pair(x1, y1), new Pair(x2, y2)));
        }

        return new Grid(x, y, new Pair(startX, startY), new Pair(endX, endY), obstacles);
    }
}

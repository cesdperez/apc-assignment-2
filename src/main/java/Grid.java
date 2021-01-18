import java.util.List;

public class Grid {

    int width;
    int height;

    Pair start;
    Pair end;

    List<Obstacle> obstacles;

    public Grid(int width, int height, Pair start, Pair end, List<Obstacle> obstacles) {
        this.width = width;
        this.height = height;
        this.start = start;
        this.end = end;
        this.obstacles = obstacles;
    }

    public boolean isInside(Pair point) {
        return point.x >= 0 && point.x <= width && point.y >= 0 && point.y <= height;
    }

    public boolean isAtEnd(Pair point) {
        return end.equals(point);
    }

    public boolean isEmpty(Pair point) {
        for (Obstacle o : obstacles) {
            if (o.isInside(point))
                return false;
        }
        return true;
    }
}

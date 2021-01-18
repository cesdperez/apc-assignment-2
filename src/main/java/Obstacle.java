public class Obstacle {

    Pair p1;
    Pair p2;

    public Obstacle(Pair p1, Pair p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public boolean isInside(Pair point) {
        return point.x >= p1.x && point.x <= p1.x && point.y >= p2.y && point.y <= p2.y;
    }
}

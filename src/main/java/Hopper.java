import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Hopper {

    final int MAX_SPEED = 4;

    Pair position;
    Pair velocity;

    public Hopper(Pair position) {
        this.position = position;
        this.velocity = new Pair(0, 0);
    }

    public List<Pair> getValidVelocities() {
        List<Pair> speeds = new LinkedList<>();

        // TODO check max speed
        speeds.add(new Pair(velocity.x - 1, velocity.y - 1));
        speeds.add(new Pair(velocity.x - 1, velocity.y));
        speeds.add(new Pair(velocity.x - 1, velocity.y + 1));
        speeds.add(new Pair(velocity.x, velocity.y - 1));
//        speeds.add(new Pair(velocity.x, velocity.y));
        speeds.add(new Pair(velocity.x, velocity.y + 1));
        speeds.add(new Pair(velocity.x + 1, velocity.y - 1));
        speeds.add(new Pair(velocity.x + 1, velocity.y));
        speeds.add(new Pair(velocity.x + 1, velocity.y + 1));
        return speeds;
    }

    public void hoop() {
        position.x += velocity.x;
        position.y += velocity.y;
//        System.out.printf("Hopper jumped to (%s,%s)%n", position.x, position.y);
    }

    public Hopper clone() {
        Hopper cloned = new Hopper(new Pair(position.x, position.y));
        cloned.velocity = new Pair(velocity.x, velocity.y);
        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hopper hopper = (Hopper) o;
        return Objects.equals(position, hopper.position) && Objects.equals(velocity, hopper.velocity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, velocity);
    }
}

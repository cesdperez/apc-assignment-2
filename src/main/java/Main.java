import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Grid grid = Parser.parseGrid(sc);
            int solution = solve(grid);
            if (solution >= 0) {
                System.out.printf("Optimal solution takes %s hops.%n", solution);
            } else {
                System.out.printf("No solution.%n");
            }
        }
    }

    private static int solve(Grid grid) {
        Set<Hopper> attempted = new HashSet<>();
        Hopper hopper = new Hopper(grid.start);
        return solveRecursive(grid, attempted, hopper, 0);
    }

    private static int solveRecursive(Grid grid, Set<Hopper> attempted, Hopper hopper, int jumps) {
        List<Integer> solutions = new LinkedList<>();
        for (Pair velocity : hopper.getValidVelocities()) {
            Hopper movedHopper = hopper.clone();
            movedHopper.velocity = velocity;
            movedHopper.hoop();
            if (attempted.contains(movedHopper)){
                solutions.add(-1);
                continue;
            }
            attempted.add(movedHopper);
            if (grid.isAtEnd(movedHopper.position)) {
                solutions.add(jumps);
            } else if (!grid.isInside(movedHopper.position)) {
                solutions.add(-1);
            } else if (!grid.isEmpty(movedHopper.position)) {
                solutions.add(-1);
            } else {
                solutions.add(solveRecursive(grid, attempted, movedHopper, jumps + 1));
            }
        }

        if (solutions.isEmpty()) {
            return -1;
        }

        Collections.sort(solutions);
        return solutions.get(0);
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Path {
    static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        int sizeOfGrid = input.nextInt();
        int amountOfObstacles = input.nextInt();
        int[][] grid = makeGrid(sizeOfGrid, amountOfObstacles);
        HashMap<String, Integer> memo = new HashMap<String, Integer>();
        System.out.println(findPath(0, 0, sizeOfGrid, sizeOfGrid, grid, memo));

    }

    public static int[][] makeGrid(int sizeOfGrid, int amountOfObstacles) {
        int[][] grid = new int[sizeOfGrid][sizeOfGrid];
        for (int i = 0; i < amountOfObstacles; i++) {
            int row = input.nextInt();
            int column = input.nextInt();
            grid[row - 1][column - 1] = 1;

        }
        return grid;

    }

    public static int findPath(int row, int column, int rows, int columns, int[][] grid,
            HashMap<String, Integer> memo) {
        String key = row + "," + column;
        // returns the amount of paths
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (row > rows - 1 || column > columns - 1 || grid[row][column] == 1) {
            return 0;
        }

        if (row == rows - 1 && column == columns - 1) {
            return 1;
        }

        int result = findPath(row + 1, column, rows, columns, grid, memo)
                + findPath(row, column + 1, rows, columns, grid, memo);

        memo.put(key, result);
        return result;

    }
}

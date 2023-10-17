
import java.util.HashMap;
import java.util.*;

public class RobotPartOne {
    public static void main(String[] args) {
        int grid = 3;
        System.out.println(gridPaths(grid, grid));
    }

    public static int gridPaths(int rows, int columns) {
        Map<String, Integer> memo = new HashMap<String, Integer>();
        return numberOfGridPaths(0, 0, rows, columns, memo);

    }

    public static int numberOfGridPaths(int row, int column, int rows, int columns, Map<String, Integer> memo) {
        String key = row + "," + column;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (row == rows - 1 && column == columns - 1) {
            return 1;
        }
        if (row > rows - 1 || column > columns - 1) {
            return 0;
        }

        else {
            int result = numberOfGridPaths(row + 1, column, rows, columns, memo)
                    + numberOfGridPaths(row, column + 1, rows, columns, memo);
            memo.put(key, result);
            return result;
        }
    }
}
import java.util.Scanner;

public class Lego {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int gridSizeRow = input.nextInt();
        int gridSizeColumns = input.nextInt();
        int[][] grid = new int[gridSizeRow][gridSizeColumns];

        for (int row = 0; row < gridSizeRow; row++) {
            for (int column = 0; column < gridSizeColumns; column++) {
                grid[row][column] = input.nextInt();
            }
        }
        input.close();
        int[][] dp = new int[gridSizeRow][gridSizeColumns];

        for (int i = 0; i < gridSizeRow; i++) {
            for (int j = 0; j < gridSizeColumns; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = Math.min(dp[i][j - 1], grid[i][j]);
                } else if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], grid[i][j]);
                } else {
                    dp[i][j] = Math.max(Math.min(dp[i - 1][j], dp[i][j - 1]), grid[i][j]);
                }
                System.out.println();
                for (int r = 0; r < dp.length; r++) {
                    for (int p = 0; p < dp[i].length; p++) {
                        System.out.print(dp[r][p] + " ");
                    }
                    System.out.println(); // Move to the next line after printing a row
                }
            }
        }

        System.out.println(dp[gridSizeRow - 1][gridSizeColumns - 1]);
    }
}

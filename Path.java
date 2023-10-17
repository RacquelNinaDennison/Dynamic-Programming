
/**
 * Problem Description
Write a program that computes the number of paths that a robot may take when navigating through a given terrain.

A terrain is represented by an NxN grid of squares.
The robot starts in the lower left square of grid, referred to as square (1, 1), and needs to move to the upper right square, referred to as (N, N).
A terrain also contains K obstacles, each of which blocks a single square on the grid.
The robot cannot move into a square containing an obstacle, so these reduce the number of possible paths through the grid.
No two obstacles block the same square, and the starting and ending squares will never contain obstacles.
The robot can only move a single square up or right with each step.
Example
Given a 3×3 grid with no obstacles, there are a total of 6 paths from the bottom left square to the top right, shown below:



Given the same grid with one obstacle on square (2, 2) there are 2 paths:



Given the same grid with one obstacle on square (2, 1) there are 3 paths:



Input and Output
Program input and output will make use of stdio streams (System.in and System.out in Java) i.e., not file I/O.

Input consists of a series of lines, each containing up to two integer values.

The first line of input contains a single integer, N, representing the size of the grid.
The second line contains a single integer K, representing the number of obstacles on the grid.
The following K lines of input each contain two integers separated by a space. Each of these lines represents the coordinates on the grid of one of the obstacles.
Output consists of a single integer P, the number of paths from the bottom left grid square to the top right grid square,followed by a line break — in Java, for example, use System.out.println, not System.out.print. The automatic marker expects this precise form.

Sample Input:

3
1
2 1

Sample output:

3

Constraints
1 < N < 20 0 < K < N

All obstacles will have coordinates within the dimensions of the grid.

The answer, P, will be bounded by 0 ≤ P ≤ 1,000,000,000

Scoring
Each test case that is answered correctly will score 5 points.
 */

import java.util.HashMap;

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

import java.util.*;

/*
 * Given a row length N calculate all possible permutations of characters B&R a row given the rule that  R's cannot follow 2 R's
example N = 3 will have the following valid permutations BBR, BBB, BRB, BRR, RRB, RBR, RRB and RRR which is not valid. Thus output will be 7
 */
public class Blocks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfRows = input.nextInt();
        input.close();
        int[] dp = new int[numberOfRows + 1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;

        for (int i = 3; i <= numberOfRows; i++) {

            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

        }

        System.out.println(dp[numberOfRows]);
    }

}

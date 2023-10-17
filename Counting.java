
/**
 * Problem Description
Consider the following pseudo-code function:
int unknown(int n) {
if (n≤0) {
print 0;
return 1;
}
else if (n==1) {
print 1;
return 1;
}
else {
return unknown(n-1)*unknown(n-3);
}
}
Given a single integer, Ni, what is the number, pi, of zeroes, and the number, qi, of ones, that will be
printed by a call to unknown with Ni as the parameter value, i.e., the number of '0's and the number
of '1's printed by the call unknown(Ni).
Example
Let Ni=3, the steps in the computation of unknown(3) are as follows:
unknown(3) becomes unknown(2)*unknown(0)
unknown(2) becomes unknown(1)*unknown(-1)
unknown(1) becomes print 1
unknown(-1) becomes print 0
unknown(0) becomes print 0
So, for Ni=3, the number of zeroes, pi, is 2, and the number of ones, qi, is 1.
Hints
You should use Java type 'long' or C++/C type 'long long' for pi and qi.
Input and Output
Program input and output will make use of stdio streams (System.in and System.out in Java)
i.e., not file I/O.
The first line of input consists of a value M, the number of cases for which the problem must be
solved, the next M lines will each contain a value for one of those cases i.e., for N0, N1, …, NM-1.
3
Continued
Sample Input:
4
3
5
10
0
Output consists of exactly M lines, one for each Ni. Each will contain exactly two space separated
integers, pi and qi, followed by a line break — in Java, for example, use System.out.println,
not System.out.print. The automatic marker expects this precise form.
Sample Output
2 1
3 3
22 19
1 0
Constraints
1 ≤ M ≤ 101, in 50% of test cases, M≤5.
0 ≤ Ni ≤ 100
Scoring
Each test case that is answered correctly will score 10 points.

 * 
 * 
 */

import java.util.Scanner;

public class Counting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();

        for (int i = 0; i < M; i++) {
            int N = scanner.nextInt();
            Pair result = countZerosOnes(N);
            System.out.println(result.p + " " + result.q);
        }
        scanner.close();
    }

    static class Pair {
        long p, q;

        Pair(long p, long q) {
            this.p = p;
            this.q = q;
        }
    }

    static Pair countZerosOnes(int n) {
        long[] zeros = new long[n + 2];
        long[] ones = new long[n + 2];

        if (n == 1) {
            return new Pair(0, 1);
        }
        if (n == 0) {
            return new Pair(1, 0);
        }

        zeros[0] = 1;
        zeros[1] = 1;
        zeros[2] = 0;

        ones[0] = 0;
        ones[1] = 0;
        ones[2] = 1;

        for (int i = 3; i <= n + 1; i++) {
            zeros[i] = zeros[i - 1] + zeros[i - 3];
            ones[i] = ones[i - 1] + ones[i - 3];
        }

        return new Pair(zeros[n + 1], ones[n + 1]);
    }
}
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
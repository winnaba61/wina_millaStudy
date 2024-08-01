import java.util.Arrays;
import java.util.Scanner;

public class BOJ_12026_BOJ거리 {
    static int N;
    static char[] blocks;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        blocks = new char[N];
        for (int i = 0; i < N; i++) {
            blocks[i] = sc.next().charAt(0);
        }
        sc.close();

        System.out.println(dp());
    }

    private static int dp() {
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            char cur = blocks[i];
            char nxt;

            if (cur == 'B') {
                nxt = 'O';
            } else if (cur == 'O') {
                nxt = 'J';
            } else {
                nxt = 'B';
            }

            for (int j = i + 1; j < N; j++) {
                if (blocks[j] == nxt) {
                    dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
                }
            }
        }

        return dp[N - 1] != Integer.MAX_VALUE ? dp[N - 1] : -1;
    }
}
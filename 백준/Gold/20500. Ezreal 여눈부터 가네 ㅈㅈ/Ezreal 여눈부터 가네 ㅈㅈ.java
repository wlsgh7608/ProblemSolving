import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][15];

        dp[1][1] = 1;
        dp[1][5] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 15; j++) {
                if (j < 1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1 + 15]) % 1_000_000_007;
                } else {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % 1_000_000_007;
                }
                if (j < 5) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 5 + 15]) % 1_000_000_007;
                } else {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 5]) % 1_000_000_007;
                }
            }
        }


        long ans = 0;
        ans = dp[N - 1][1] + dp[N - 1][4] + dp[N - 1][7] + dp[N - 1][10] + dp[N - 1][13];
        ans = ans % 1_000_000_007;
        System.out.println(ans);


    }
}

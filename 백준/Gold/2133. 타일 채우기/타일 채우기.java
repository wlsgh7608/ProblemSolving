import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[31];

        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= N; i += 2) {
            int result = dp[i - 2] * dp[2];
            for (int j = 0; j <= i - 4; j += 2) {
                result += dp[j] * 2;
            }
            dp[i] = result;
        }

        System.out.println(dp[N]);

    }
}

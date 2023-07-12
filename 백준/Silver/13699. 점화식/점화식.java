import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[36];
        dp[0] = 1;
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            for(int j = 0; j<i;j++){
                dp[i] += dp[j] * dp[i - j-1];
            }
        }
        System.out.println(dp[N]);
    }
}

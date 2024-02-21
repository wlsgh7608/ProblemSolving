import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int N = str.length();

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        int prevTwo = str.charAt(0) - '0';
        for (int i = 2; i <= str.length(); i++) {
            int prevOne = str.charAt(i - 1) - '0';
            int num = prevTwo * 10 + prevOne;
            if (prevOne != 0) {
                dp[i] += dp[i - 1];
            }
            if (num >= 10 && num <= 34) {
                dp[i] += dp[i - 2];
            }
            prevTwo = prevOne;

        }
        System.out.println(dp[N]);
    }
}

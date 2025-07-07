import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[1000 + 2][5];

        dp[1][0] =1;
        for (int i = 2; i < 1000 + 2; i++) {
            dp[i][0] = dp[i - 2][0] + dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][4] + dp[i - 1][3];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][4];
            dp[i][2] = dp[i - 1][3];
            dp[i][3] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][4] = dp[i - 1][0] + dp[i - 1][1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i <T;i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N + 1][0]).append("\n");
        }

        System.out.println(sb);
    }
}

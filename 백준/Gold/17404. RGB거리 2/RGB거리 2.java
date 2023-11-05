import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // end input

        //[단계][현재]
        int minSum = Integer.MAX_VALUE;
        for (int c = 0; c < 3; c++) {
            int[][] dp = new int[N][3];
            Arrays.fill(dp[0], 1_000);
            dp[0][c] = arr[0][c];
            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
            }
            for (int i = 0; i < 3; i++) {
                if (i != c) {
                    minSum = Math.min(minSum, dp[N - 1][i]);
                }
            }

        }
        System.out.println(minSum);

    }
}

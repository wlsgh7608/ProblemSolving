import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][N+1];
            dp[0][1] = arr[0][0];
            dp[1][1] = arr[1][0];

            for(int i =  2; i<=N;i++){
                int maxMinus2 = Math.max(dp[0][i - 2], dp[1][i - 2]);
                dp[0][i] = Math.max(dp[1][i - 1],maxMinus2) + arr[0][i - 1];
                dp[1][i] = Math.max(dp[0][i - 1], maxMinus2) + arr[1][i - 1];
            }
            int max = Math.max(dp[0][N], dp[1][N]);
            sb.append(max).append("\n");
        }
        System.out.println(sb);

    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][3];
        int[][] dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i][n-1]++;
        }

        for (int i = 1; i <= N; i++) {
            for(int j = 0; j<3;j++){
                dp[i][j] = dp[i - 1][j] + arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<Q;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int ans1 = dp[b][0] - dp[a-1][0];
            int ans2 = dp[b][1] - dp[a-1][1];
            int ans3 = dp[b][2] - dp[a-1][2];
            sb.append(ans1 + " " + ans2 + " " + ans3).append("\n");
        }
        System.out.println(sb);


    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        long[][] dp = new long[N + 1][M + 1];

        dp[0][0] = 1;
        for(int i = 1; i<=N;i++){
            for(int j = 1; j<=M;j++){
                long tmp = (dp[i - 1][j - 1] + dp[i - 1][j]) % 1_000_000_007;
                dp[i][j] = (tmp + dp[i][j - 1])%1_000_000_007;
            }
        }
        System.out.println(dp[N][M]);


    }
}

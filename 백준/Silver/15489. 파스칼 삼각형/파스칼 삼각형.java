import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[][] dp = new long[31][31];

        dp[1][1] = 1;
        for(int i = 2; i<=30;i++){
            for(int j =1;j<=30;j++){
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        long result = 0;
        for(int i =0 ;i<W;i++){
            for(int j = 0;j<=i;j++){
                result += dp[R + i][C + j];
            }
        }
        System.out.println(result);

    }
}

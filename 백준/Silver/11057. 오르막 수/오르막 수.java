import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];
        dp[0][9]= 1;
        for(int i = 1; i<=N;i++){
            for(int j = 0; j <10;j++){
                for(int k = j;k<10;k++){
                    dp[i][j] += dp[i - 1][k];
                }
            dp[i][j] = dp[i][j]%10_007;
            }
        }

        int sum = 0;
        for(int j = 0; j<10;j++){
            sum += dp[N][j];
        }
        sum = sum%10_007;
        System.out.println(sum);

    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];
        for(int i = 1;i<=N;i++){
            dp[i] = 1;
            if(i==3){
                break;
            }
        }

        for(int i = 4;i<=N;i++){
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        System.out.println(dp[N]);

    }
}

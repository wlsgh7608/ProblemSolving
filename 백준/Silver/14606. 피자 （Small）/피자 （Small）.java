import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main     {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[11];

        dp[0]=0;
        dp[1] = 0;
        dp[2] = 1;
        for(int i =3;i<=10;i++){
            int m = (i/2);
            int a = m;
            int b = i-a;

            dp[i] = a*b+dp[a]+dp[b];
        }
        System.out.println(dp[N]);
    }
}

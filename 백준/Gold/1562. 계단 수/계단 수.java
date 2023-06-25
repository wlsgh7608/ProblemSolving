import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static int dfs(int n ,int lastN,int flag){
        if (dp[n][lastN][flag] > 0) {
            return dp[n][lastN][flag];
        }

        if(n ==N){
            if(flag == (1<<10)-1){
                return 1;
            }
            return 0;
        }

        if(lastN>0){
            dp[n][lastN][flag] = (dp[n][lastN][flag] + dfs(n + 1, lastN - 1, flag | (1 << (lastN - 1)))) % 1_000_000_000;
        }
        if(lastN<9){
            dp[n][lastN][flag] = (dp[n][lastN][flag] + dfs(n + 1, lastN + 1, flag | (1 << (lastN + 1)))) % 1_000_000_000;
        }
        return dp[n][lastN][flag];
    }


    static int N;
    static int[][][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
        dp = new int[N+1][10][1 << 10];

        int result = 0;

        for(int i = 1;i<10;i++){
            int ans = dfs(1, i, 1 << i);
            result+= ans;
            result = result % 1_000_000_000;
        }
        System.out.println(result);






    }
}

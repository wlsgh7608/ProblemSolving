import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int MOD = 1_000_000_009;
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] dp = new int[100_001][3];

		dp[1][0] = 1;
		dp[2][1] = 1;
		dp[3][2] = 1;
		
		for(int i = 1;i<=100_000;i++) {
			if(i>=2) {
				dp[i][1]=(dp[i][1]+dp[i-2][0])%MOD;
				dp[i][1]+=dp[i-2][2];
				dp[i][1] = dp[i][1]%MOD;
			}
			if(i>=3) {
				dp[i][2] +=dp[i-3][0];
				dp[i][2] = dp[i][2]%MOD;
				dp[i][2] +=dp[i-3][1];
				dp[i][2] = dp[i][2]%MOD;
			}
			dp[i][0] +=dp[i-1][1];
			dp[i][0] = dp[i][0]%MOD;
			dp[i][0] +=dp[i-1][2];
			dp[i][0] = dp[i][0]%MOD;
		}
		int[] ans  = new int[100_001];
		for(int i = 1;i <100_001;i++) {
			ans[i] = ((dp[i][0]+dp[i][1])%MOD+dp[i][2])%MOD;
		}
	
		
		for(int i = 0; i<N;i++) {
			int p = Integer.parseInt(br.readLine());
			sb.append(ans[p]).append("\n");
		}
		System.out.println(sb);
	}

}

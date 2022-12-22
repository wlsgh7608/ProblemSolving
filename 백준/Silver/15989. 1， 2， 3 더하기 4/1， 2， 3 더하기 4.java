import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[][] dp = new long[10_001][3];
		dp[1][0] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		dp[3][0] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		for(int i = 4;i<=10000;i++) {
			dp[i][0] = dp[i-1][0];
			dp[i][1] = dp[i-2][0]+dp[i-2][1];
			dp[i][2] = dp[i-3][0]+dp[i-3][1]+dp[i-3][2];
		}
		StringBuilder sb= new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			long ans  = 0;
			for(long v : dp[n]) {
				ans+=v;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long[][] dp = new long[31][31];
		for(int j = 0;j<31;j++) {
			dp[0][j] = 1;
		}
		for(int i =1;i<31;i++) {
			for(int j = 0; j<30;j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j+1];
				}
				else {
					dp[i][j] = dp[i-1][j+1]+dp[i][j-1];
				}
				
			}
				
		}
		
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				break;
			}
			sb.append(dp[n][0]).append("\n");
		}
		System.out.println(sb);

	}

}

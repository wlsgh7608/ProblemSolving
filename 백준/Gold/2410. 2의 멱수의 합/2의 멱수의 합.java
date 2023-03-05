import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[N+1];
		for(int i = 0 ; (int)Math.pow(2, i)<=N;i++) {
			int cur = (int) Math.pow(2, i) ;
			dp[cur] = 1;
		}
		dp[0] = 1;
		
		for(int i = 1; i<=N;i++) {
			if(i%2==1) {
				dp[i] = dp[i-1];
			}else {
				dp[i] = (dp[i-1]+dp[i/2])%1_000_000_000;
			}
		}
		System.out.println(dp[N]);
	}

}

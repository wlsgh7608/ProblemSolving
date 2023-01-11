import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		Arrays.fill(dp, 100_000);
		dp[0] = 0;
		for(int i = 1;i <=N;i++) {
			for(int j = 1; j*j<=i;j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		System.out.println(dp[N]);
		
		
	}

}

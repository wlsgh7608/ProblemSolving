import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long[][] dp = new long[N+1][21];
		dp[0][arr[0]] = 1;
		
		for(int i = 1; i<N-1;i++) {
			int cur = arr[i];
			for(int  j = 0; j<21;j++) {
				if(j+cur <=20) {
					dp[i][j+cur] += dp[i-1][j];
				}
				if(j-cur>=0) {
					dp[i][j-cur]+= dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N-2][arr[N-1]]);
	}
}

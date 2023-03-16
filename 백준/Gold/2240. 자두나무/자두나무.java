import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		for(int i = 1; i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[][][] dp = new int[N+1][M+2][2];
		for(int i = 1 ; i <=N;i++) {
			for(int j = 1; j<=M+1;j++) {
				if(arr[i]==1) {
					dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1])+1;
					dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0]);
				}else {
					if(i==1&&j==1) {
						continue;
					}
					dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1]);
					dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0])+1;
					
				}
			}
		}
		
		
		
		int result= 0;
		for(int i = 1; i<=M+1;i++) {
			result = Math.max(result, dp[N][i][0]);
			result = Math.max(result, dp[N][i][1]);
		}
		System.out.println(result);
		
	}

}

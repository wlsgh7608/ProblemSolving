import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] G = new int[N][3];
		int[][] dp = new int[N+1][3];
		
		for(int i = 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<3;j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = N-1;i>=0;i--) {
			for(int j = 0;j<3;j++) {
				if(j>0) {
					dp[i][j] = Math.max(dp[i][j], G[i][j]+dp[i+1][j-1]);
				}
				dp[i][j] = Math.max(dp[i][j], G[i][j]+dp[i+1][j]);
				
				if(j<2) {
					dp[i][j] = Math.max(dp[i][j], G[i][j]+dp[i+1][j+1]);
				}
			}
		}
		int max_n = 0;
		for(int n:dp[0]) {
			max_n  = n>max_n?n:max_n;
		}
		
		int[][] dp_min = new int[N+1][3];
		for(int[] row:dp_min) {
			Arrays.fill(row,Integer.MAX_VALUE);
		}
		for(int i = 0;i<3;i++) {
			dp_min[N][i] = 0;
		}
		for(int i = N-1;i>=0;i--) {
			for(int j = 0;j<3;j++) {
				if(j>0) {
					dp_min[i][j] = Math.min(dp_min[i][j], G[i][j]+dp_min[i+1][j-1]);
				}
				dp_min[i][j] = Math.min(dp_min[i][j], G[i][j]+dp_min[i+1][j]);
				
				if(j<2) {
					dp_min[i][j] = Math.min(dp_min[i][j], G[i][j]+dp_min[i+1][j+1]);
				}
			}
		}
		int min_n = Integer.MAX_VALUE;
		for(int n:dp_min[0]) {
			min_n  = n<min_n?n:min_n;
		}
		System.out.println(max_n +" "+min_n);
		
		
		
		
		
		
		
		
	}

}

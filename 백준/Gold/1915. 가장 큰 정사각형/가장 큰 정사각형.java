import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] g = new int[N+1][M+1];
		int[][] dp = new int[N+1][M+1];
		Arrays.fill(dp[0], 1);
		for(int i = 0; i<N+1;i++) {
			dp[i][0] = 1;
		}
		
		for(int i = 1;i <N+1;i++) {
			String input = br.readLine();
			for(int j = 1; j<M+1;j++) {
				g[i][j] = input.charAt(j-1)-'0';
			}
		}
		
		int max_len = 0;
		
		for(int i = 1;i<N+1;i++) {
			for(int j = 1; j<M+1;j++) {
				dp[i][j] = dp[i][j];
				int r = g[i-1][j] ==1 ? dp[i-1][j]:0;
				int c = g[i][j-1] ==1 ? dp[i][j-1]:0;
				int d = g[i-1][j-1] ==1 ? dp[i-1][j-1]:0;
				if(g[i][j] == 1) {
					int temp = Math.min(r, c);
					temp = Math.min(temp, d);
					dp[i][j] = temp+1;
					max_len = Math.max(max_len, dp[i][j]);
					
				}
			}
		}
		
		System.out.println(max_len*max_len);
		
	}

}

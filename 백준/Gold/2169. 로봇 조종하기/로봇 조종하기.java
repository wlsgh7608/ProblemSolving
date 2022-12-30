import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][][] dp;
	static int[][] G;
	static int[] dx = {0,1,0};
	static int[] dy = {1,0,-1};
	static int N;
	static int M;
	static boolean[][] visited;
	
	public static int dfs(int x, int y, int d) {
		if(x==N-1 && y==M-1) {
			return G[x][y];
		}
		if(dp[x][y][d]!=-1_000_000_000) {
			return dp[x][y][d];
		}
		
		
		visited[x][y] = true;
		
		
		int ans = -200_000;
		for(int i = 0 ;i<3;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0||ny<0||nx>=N||ny>=M || visited[nx][ny]) {
				continue;
			}
			ans = Math.max(ans, G[x][y] + dfs(nx,ny,i));
		}
		visited[x][y] = false;
		
		return dp[x][y][d] = ans;

	}

	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = new int[N][M];
		dp = new int[N][M][3];
		for(int[][] table: dp) {
			for(int[] row:table)
			Arrays.fill(row, -1_000_000_000);
		}
		visited = new boolean[N][M];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<M;j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(0,0,0));
		
		
	}
}




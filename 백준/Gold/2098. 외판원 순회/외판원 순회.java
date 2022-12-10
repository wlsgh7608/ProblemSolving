import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int dfs(int v, int flag) { // flag 방문한 도시들 bit
		if (Integer.bitCount(flag) == N) { // 다 찾음
			if (G[v][0] == 0) {
				return INF/2;
			}
			return G[v][0]; // 마지막 -> 출발
		}
		// 탐색은 어떻게 할 것인가??
		if (dp[v][flag] != INF) {// 값 존재
			return dp[v][flag];
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0 || G[v][i] == 0) {
				continue;
			}
			dp[v][flag] = Math.min(dp[v][flag], dfs(i, flag | 1 << i) + G[v][i]);
		}
		return dp[v][flag];
	}

	static int N;
	static int[][] dp;
	static int[][] G;
	static final int INF = 100_000_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		G = new int[N][N];
		dp = new int[N][(int) Math.pow(2, N)]; // 현재 정점,방문한 정점 비트

		for (int[] row : dp) {
			Arrays.fill(row, INF);
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(0, 1));
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static void dfs(int n, int bf) {

		dp[n][1] = arr[n];
		for (int next : adjList[n]) {
			if (next != bf) {
				dfs(next, n);
				dp[n][0] += Math.max(dp[next][0], dp[next][1]);
				dp[n][1] += dp[next][0];

			}
		}

	}

	static int[][] dp;
	static int[] arr;
	static List<Integer>[] adjList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		adjList = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}

		dp = new int[N + 1][2];
		dfs(1, -1);
		System.out.println(Math.max(dp[1][0],dp[1][1]));

	}

}

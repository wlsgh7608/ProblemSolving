import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static void dfs(int depth, int sum) {
		if (depth == 4) {
			return;
		}
		if (sum == N) {
			min = Math.min(min, depth);
		}
		for (int i = 1; i * i + sum <= N; i++) {
			if (dp[i*i+sum] > depth + 1) {
				dp[i*i+sum] = depth + 1;
				dfs(depth + 1, i * i + sum);
			}
		}
	}

	static int min = 4;
	static int N;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		Arrays.fill(dp, 4);
		dfs(0, 0);
		System.out.println(min);
	}

}

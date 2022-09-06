import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dp = new int[K + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int[] coins = new int[N + 1];
		for (int i = 0; i < N; i++) {
			int c = Integer.parseInt(br.readLine());
			coins[i] = c;
		}

		for (int i = 1; i < K + 1; i++) {
			for (int c : coins) {
				if (i - c >= 0 && dp[i - c] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - c] + 1);
				}
			}
		}
		if (dp[K] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[K]);
		}

	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		Arrays.fill(dp, 100_000);
		dp[0] = 0;

		for (int i = 1; i * 5 <= N; i++) {
			dp[i * 5] = i;
		}

		for (int i = 2; i <= N; i++) {
			dp[i] = Math.min(dp[i - 2] + 1, dp[i]);
		}

		if(dp[N]==100_000) {
			System.out.println(-1);
		}else {
			System.out.println(dp[N]);
		}

	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[70];

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 70; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int q = Integer.parseInt(br.readLine());
			sb.append(dp[q]).append("\n");

		}
		System.out.println(sb);
	}

}

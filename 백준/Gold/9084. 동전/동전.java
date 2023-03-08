import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			int[][] dp = new int[N + 1][M + 1];
			for (int i = 0; i <= N; i++) {
				dp[i][0] = 1;
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					dp[i][j] += dp[i - 1][j];
				}

				for (int j = arr[i]; j <= M; j++) {
					dp[i][j] += dp[i][j - arr[i]];
				}
			}
			sb.append(dp[N][M]).append("\n");
		}
		System.out.println(sb);

	}
}

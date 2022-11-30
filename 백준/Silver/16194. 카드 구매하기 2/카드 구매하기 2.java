import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N + 1];
		Arrays.fill(dp, 1_000_000_000);
		dp[0] = 0;
		for (int i = 1; i < N + 1; i++) { // 선택한 거
			for (int j = i; j < N + 1; j++) {
				dp[j] = Math.min(dp[j], dp[j - i] + arr[i]);

			}
		}
		System.out.println(dp[N]);
	}
}

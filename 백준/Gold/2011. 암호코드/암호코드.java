import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static boolean isImpossible(int prev, int cur) {
		if (cur == 0) {
			if (prev != 1 && prev != 2) {
				return true;
			}
		}
		return false;
	}

	static boolean is2Word(int prev, int cur) {
		if (prev == 1) {
			return true;
		} else if (prev == 2 && cur <= 6) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int N = input.length;
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = input[i - 1] - '0';
		}

		int[][] dp = new int[N + 1][2]; // 2자리 X, 2자리 O
		dp[0][0] = 1;
		for (int i = 1; i <= N; i++) {
			int cur = arr[i];
			int prev = arr[i - 1];
			if (isImpossible(prev, cur)) {
				break;
			}
			if (is2Word(prev, cur)) {
				if (cur == 0) {
					dp[i][1] = dp[i - 1][0];
				} else {
					dp[i][0] = (dp[i - 1][1] + dp[i - 1][0]) % 1_000_000;
					dp[i][1] = dp[i - 1][0];
				}
			} else {
				dp[i][0] = (dp[i - 1][1] + dp[i - 1][0]) % 1_000_000;
			}
		}
		int result = (dp[N][0] + dp[N][1]) % 1_000_000;
		System.out.println(result);

	}

}

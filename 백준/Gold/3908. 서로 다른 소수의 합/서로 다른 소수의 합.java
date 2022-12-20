import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX_NUM = 1120;
	private static final int MAX_K = 14;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isPrime = new boolean[MAX_NUM + 1];
		List<Integer> primeList = new ArrayList<>();
		Arrays.fill(isPrime, true);
		for (int i = 2; i <= (int)(Math.pow(MAX_NUM, 0.5)); i++) {
			for (int j = 2; j * i <= MAX_NUM; j++) {
				isPrime[i * j] = false;
			}
		}

		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[MAX_K + 1][MAX_NUM + 1];
		for (int i = 2; i <= MAX_NUM; i++) {
			if (isPrime[i]) {
				primeList.add(i);
			}
		}
		dp[0][0] = 1;
		for (int prime : primeList) {
			for (int j = MAX_NUM; j >= 2; j--) {
				for (int i = 1; i <= MAX_K; i++) {
					if (j >= prime) {
						dp[i][j] += dp[i - 1][j - prime];

					}
				}
			}

		}

		StringBuilder sb= new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			sb.append(dp[k][n]).append("\n");
		}
		System.out.println(sb);

	}

}

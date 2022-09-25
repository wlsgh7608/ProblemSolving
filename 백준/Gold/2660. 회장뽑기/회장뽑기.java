import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] G = new int[N + 1][N + 1];
		for (int[] row : G) {
			Arrays.fill(row, 100);
		}
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1) {
				break;
			}
			G[a][b] = 1;
			G[b][a] = 1;
		}

		for (int i = 1; i < N + 1; i++) {
			G[i][i] = 0;
		}

		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					G[i][j] = Math.min(G[i][j], G[i][k] + G[k][j]);
				}
			}
		}

		List<Integer> ans = new ArrayList<>();
		int min_n = Integer.MAX_VALUE;
		for (int i = 1; i < N + 1; i++) {
			int result = 0;
			for (int j = 1; j < N + 1; j++) {
				result = G[i][j] > result ? G[i][j] : result;
			}
			if (result < min_n) {
				min_n = result;
				ans.clear();
				ans.add(i);
			} else if (result == min_n) {
				ans.add(i);
			}

		}

		System.out.println(min_n + " " + ans.size());
		for (int n : ans) {
			System.out.print(n + " ");
		}

	}

}


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static char[][] copy(char[][] G) {
		char[][] newG = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newG[i][j] = G[i][j];
			}
		}

		return newG;
	}

	static void check(char[][] G) {

		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 1; j < N; j++) {
				if (G[i][j] == G[i][j - 1]) {
					cnt++;
				} else {
					cnt = 1;
				}
				max = Math.max(max, cnt);
			}
		}

		for (int j = 0; j < N; j++) {
			int cnt = 1;
			for (int i = 1; i < N; i++) {
				if (G[i][j] == G[i - 1][j]) {
					cnt++;
				} else {
					cnt = 1;
				}
				max = Math.max(max, cnt);
			}
		}

	}

	static int N;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] G = new char[N][N];

		for (int i = 0; i < N; i++) {
			G[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				char[][] newG = copy(G);
				char tmp = newG[i][j];
				newG[i][j] = newG[i][j - 1];
				newG[i][j - 1] = tmp;
				check(newG);
			}
		}

		for (int j = 0; j < N; j++) {
			for (int i = 1; i < N; i++) {
				char[][] newG = copy(G);
				char tmp = newG[i][j];
				newG[i][j] = newG[i - 1][j];
				newG[i - 1][j] = tmp;
				check(newG);
			}
		}

		System.out.println(max);

	}

}

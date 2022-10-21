import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] simulate(int[][] G, int d) {
		int[][] newG = copy(G);

		if (d == 0) { // 상
			for (int i = 0; i < N; i++) {
				int idx = 0;
				int v = 0;
				for (int j = 0; j < N; j++) {
					if (newG[j][i] != 0) {
						if (newG[j][i] == v) {
							newG[j][i] = 0;
							newG[idx - 1][i] = v * 2;
							v = 0;
						} else {
							v = newG[j][i];
							newG[j][i] = 0;
							newG[idx][i] = v;
							idx += 1;
						}
					}
				}
			}

		} else if (d == 1) { // 하
			for (int i = 0; i < N; i++) {
				int idx = N-1;
				int v = 0;
				for (int j = N-1; j >=0; j--) {
					if (newG[j][i] != 0) {
						if (newG[j][i] == v) {
							newG[j][i] = 0;
							newG[idx + 1][i] = v * 2;
							v = 0;
						} else {
							v = newG[j][i];
							newG[j][i] = 0;
							newG[idx][i] = v;
							idx -= 1;
						}
					}
				}
			}

		} else if (d == 2) { // 좌
			for (int i = 0; i < N; i++) {
				int idx = 0;
				int v = 0;
				for (int j = 0; j < N; j++) {
					if (newG[i][j] != 0) {
						if (newG[i][j] == v) {
							newG[i][j] = 0;
							newG[i][idx-1] = v * 2;
							v = 0;
						} else {
							v = newG[i][j];
							newG[i][j] = 0;
							newG[i][idx] = v;
							idx += 1;
						}
					}
				}
			}

		} else if (d == 3) { // 우
			for (int i = 0; i < N; i++) {
				int idx = N-1;
				int v = 0;
				for (int j = N-1; j>=0; j--) {
					if (newG[i][j] != 0) {
						if (newG[i][j] == v) {
							newG[i][j] = 0;
							newG[i][idx+1] = v * 2;
							v = 0;
						} else {
							v = newG[i][j];
							newG[i][j] = 0;
							newG[i][idx] = v;
							idx -= 1;
						}
					}
				}
			}

		}
		return newG;

	}

	static int maxV = 0;

	static void dfs(int depth, int d, int[][] G) {
		if (depth == 5) {

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					maxV = Math.max(maxV, G[i][j]);
				}
			}
			
			return;
		}

		int[][] newG = simulate(G, d);
		
		for(int i = 0; i<4;i++) {
			dfs(depth + 1, i, newG);
			
		}


	}

	static int[][] copy(int[][] G) {
		int[][] newG = new int[N][N];
		for (int i = 0; i < N; i++) {
			newG[i] = G[i].clone();
		}
		return newG;
	}

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] G = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i<4;i++) {
			dfs(0, i, G);
		}
		System.out.println(maxV);

	}

}

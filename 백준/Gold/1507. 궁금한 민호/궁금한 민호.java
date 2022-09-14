import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] G = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] isUse = new boolean[N][N];
		for (boolean[] row : isUse) {
			Arrays.fill(row, true);
		}
		
		boolean isPossible =true;
		
		
		breakLoop:
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (k == i || k==j||i==j)
						continue;

					if (G[i][j] == G[i][k] + G[k][j]) {
						isUse[i][j] = false;
					}
					if(G[i][j]>G[i][k]+G[k][j]) {
						isPossible = false;
						break breakLoop;
					}

				}
			}
		} // endfor
		if(isPossible) {
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					if (isUse[i][j]) {
						result += G[i][j];
					}
				}
			}
			System.out.println(result);
		}
		else {
			System.out.println(-1);
		}

		

	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int X;
	static int[][] G;

	static boolean check(int idx, boolean isRow) {
		int[] h = new int[N];
		if (isRow) {
			for (int i = 0; i < N; i++) {
				h[i] = G[idx][i];
			}
		} else {
			for (int i = 0; i < N; i++) {
				h[i] = G[i][idx];
			}
		}

		int p = 1;
		int sameCnt = 1;
		while (p < N) {
			int diff = h[p] - h[p - 1];
			if (diff <= -2 || diff >= 2) {
				return false;
			}
			if (diff == 1) {
				if (sameCnt < X) {
					return false;
				} else {
					sameCnt = 1;
				}
			} else if (diff == -1) {
				for (int i = 0; i < X - 1; i++) {
					p++;
					if (p >= N) {
						return false;
					}
					if (h[p] != h[p - 1]) {
						return false;
					}
					sameCnt=0;
				}
			} else {
				sameCnt++;
			}
			p++;
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			G = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					G[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				if (check(i, false)) {
					cnt++;
				}
				if (check(i, true)) {
					cnt++;
				}
				

			}
			sb.append("#" + tc + " " + cnt).append("\n");

		}
		System.out.println(sb);
	}

}

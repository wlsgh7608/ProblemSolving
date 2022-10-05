import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static Tonado[] T;
	static int N;
	static int M;
	static int[][] G;
	static int[][] newMap;
	static int K;
	static boolean[] isSelected;
	static int[] orders;

	static int[] dX = { 1, 0, -1, 0 };
	static int[] dY = { 0, 1, 0, -1 };
	static int resultMin = Integer.MAX_VALUE;

	static class Tonado {
		int x;
		int y;
		int l;

		public Tonado(int x, int y, int l) {
			super();
			this.x = x;
			this.y = y;
			this.l = l;
		}

		@Override
		public String toString() {
			return "Tonado [x=" + x + ", y=" + y + ", l=" + l + "]";
		}

	}

	static int[][] copy() {
		int[][] newG = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newG[i][j] = G[i][j];

			}
		}
		return newG;
	}

	static void rotate(Tonado t) {
		int r = t.x;
		int c = t.y;
		int s = t.l;

		for (int p = 0; p < s; p++) {
			int sX = r - s + p;
			int sY = c - s + p;
			int cur = newMap[sX][sY];

			int x = sX;
			int y = sY;

			for (int i = 0; i < 4; i++) {
				int dx = dX[i];
				int dy = dY[i];
				for (int j = 0; j < (s - p) * 2; j++) {
					int nx = x + dx;
					int ny = y + dy;
					newMap[x][y] = newMap[nx][ny];
					x = nx;
					y = ny;
				}

			}
			newMap[sX][sY + 1] = cur;
		}
	}

	static void perm(int cnt) {
		if (cnt == K) {
			newMap = copy();
			for (int i = 0; i < K; i++) {
				rotate(T[orders[i]]);
			}
			for (int[] row : newMap) {
				int caseResult = 0;
				for (int n : row) {
					caseResult += n;
				}
				resultMin = caseResult < resultMin ? caseResult : resultMin;
			}

			return;
		}

		for (int i = 0; i < K; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				orders[cnt] = i;
				perm(cnt + 1);
				isSelected[i] = false;

			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		G = new int[N][M];
		T = new Tonado[K];
		orders = new int[K];

		isSelected = new boolean[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			T[i] = new Tonado(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()));
		}

		perm(0);
		System.out.println(resultMin);

	}

}


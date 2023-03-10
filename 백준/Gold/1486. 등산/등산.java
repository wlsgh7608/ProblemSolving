import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Jump implements Comparable<Jump> {
		int x;
		int y;
		int t;

		public Jump(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
		}

		@Override
		public int compareTo(Jump o) {
			return this.t - o.t;
		}

	}

	static int back(int x, int y) {
		PriorityQueue<Jump> PQ = new PriorityQueue<>();

		int[][] time = new int[N][M];
		for (int[] row : time) {
			Arrays.fill(row, 1_000_001);
		}
		time[x][y] = 0;
		PQ.add(new Jump(x, y, 0));
		int result = 1_000_000;

		while (!PQ.isEmpty()) {
			Jump cur = PQ.poll();
			int cx = cur.x;
			int cy = cur.y;
			int ct = cur.t;

			if (cx == 0 && cy == 0) {
				result = ct;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				int diff = Math.abs(iG[nx][ny] - iG[cx][cy]);
				if (diff > T) {
					continue;
				}

				if (iG[nx][ny] <= iG[cx][cy]) {
					int nt = ct + 1;
					if (nt < D && time[nx][ny] > nt) {
						time[nx][ny] = nt;
						PQ.add(new Jump(nx, ny, nt));
					}
				} else {
					int nt = ct + diff * diff;

					if (nt < D && time[nx][ny] > nt) {
						time[nx][ny] = nt;
						PQ.add(new Jump(nx, ny, nt));
					}
				}

			}

		}
		return result;

	}

	static int N;
	static int M;
	static int T;
	static int D;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] iG;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		char[][] G = new char[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			G[i] = input.toCharArray();
		}
		iG = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				iG[i][j] = G[i][j] - 'A';
				if ('a' <= G[i][j] && G[i][j] <= 'z') {
					iG[i][j] -= 6;
				}

			}
		}

		int[][] time = new int[N][M];
		for (int[] row : time) {
			Arrays.fill(row, 1_000_001);
		}
		time[0][0] = 0;

		Queue<Jump> Q = new ArrayDeque<>();
		Q.add(new Jump(0, 0, 0));
		while (!Q.isEmpty()) {
			Jump cur = Q.poll();
			int x = cur.x;
			int y = cur.y;
			int t = cur.t;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				int diff = Math.abs(iG[nx][ny] - iG[x][y]);
				if (diff > T) {
					continue;
				}

				if (iG[nx][ny] <= iG[x][y]) {
					int nt = t + 1;
					if (nt < D && time[nx][ny] > nt) {
						time[nx][ny] = nt;
						Q.add(new Jump(nx, ny, nt));
					}
				} else {
					int nt = t + diff * diff;

					if (nt < D && time[nx][ny] > nt) {
						time[nx][ny] = nt;
						Q.add(new Jump(nx, ny, nt));
					}
				}

			}
		} // end for
		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if ( time[i][j] + back(i, j) <= D) {
					max = Math.max(max, iG[i][j]);
				}
			}
		}
		System.out.println(max);

	}
}

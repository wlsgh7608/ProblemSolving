import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Move {
		int x;
		int y;
		int cnt;
		int can;

		public Move(int x, int y, int cnt, int can) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.can = can;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] G = new int[N][M];
		int[][] ans = new int[N][M];
		int[][] canBreak = new int[N][M];

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				G[i][j] = row.charAt(j) - '0';
			}
		}
		for (int[] row : ans) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		Queue<Move> q = new ArrayDeque<>();
		q.add(new Move(0, 0, 1, K));
		ans[0][0] = 1;
		canBreak[0][0] = K;
		int answer = -1;

		while (!q.isEmpty()) {
			Move cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int cnt = cur.cnt;
			int can = cur.can;

			if (x == N - 1 && y == M - 1) {
				answer = cnt;
				break;

			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if (G[nx][ny] == 0) {
					if (ans[nx][ny] > cnt + 1) {
						ans[nx][ny] = cnt + 1;
						canBreak[nx][ny] = can;
						q.add(new Move(nx, ny, cnt + 1, can));
					} else if (canBreak[nx][ny] < can) {
						canBreak[nx][ny] = can;
						q.add(new Move(nx, ny, cnt + 1, can));
					}
				} else {
					if (can > 0) {
						if (ans[nx][ny] > cnt + 1) {
							ans[nx][ny] = cnt + 1;
							canBreak[nx][ny] = can - 1;
							q.add(new Move(nx, ny, cnt + 1, can - 1));
						} else if (canBreak[nx][ny] < can - 1) {
							canBreak[nx][ny] = can - 1;
							q.add(new Move(nx, ny, cnt + 1, can - 1));
						}

					}

				}

			}
		} // end while

		System.out.println(answer);

	}

}

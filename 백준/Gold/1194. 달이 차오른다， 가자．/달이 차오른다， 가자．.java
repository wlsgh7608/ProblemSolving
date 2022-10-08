import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int x;
		int y;
		int cnt;
		int keys;

		public Point(int x, int y, int cnt, int keys) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.keys = keys;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		char[][] G = new char[N][M];
		boolean[][][] visited = new boolean[N][M][64];
		// x,y 열쇠?
		Queue<Point> Q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				G[i][j] = row.charAt(j);
				if (G[i][j] == '0') {
					boolean[] keys = new boolean[7];
					keys[0] = true;
					Q.add(new Point(i, j, 0, 0));
				}
			}
		}
		int result = -1;

		while (!Q.isEmpty()) {
			Point cur = Q.poll();
			int x = cur.x;
			int y = cur.y;
			int cnt = cur.cnt;
			int keys = cur.keys;
			if (G[x][y] == '1') {
				result = cnt;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || G[nx][ny] == '#') {
					continue;
				}
				int newKeys = keys;
				if (!Character.isUpperCase(G[nx][ny])) {
					if (!visited[nx][ny][keys]) {

						visited[nx][ny][keys] = true;

						if (Character.isLowerCase(G[nx][ny])) {
							int idx = G[nx][ny] - 'a';
							newKeys = keys | 1 << idx;
						}
						Q.add(new Point(nx, ny, cnt + 1, newKeys));
					}

				} else { // 대문자인 경우 소문자가 있어야 함.
					if (!visited[nx][ny][keys]) {
						visited[nx][ny][keys] = true;
						int idx = G[nx][ny] + 32 - 'a';
						if ((keys & 1 << idx) != 0) {
							Q.add(new Point(nx, ny, cnt + 1, newKeys));

						}

					}
				}

			}

		} // end while
		System.out.println(result);

	}

}

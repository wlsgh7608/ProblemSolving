import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] G = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (G[i][j] == 1 && !visited[i][j]) {
					cnt++;
					Queue<Paint> Q = new ArrayDeque<>();
					Q.add(new Paint(i, j));
					visited[i][j] = true;
					int size = 0;
					while (!Q.isEmpty()) {
						Paint cur = Q.poll();
						size++;
						for (int d = 0; d < 4; d++) {
							int nx = cur.x + dx[d];
							int ny = cur.y + dy[d];
							if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
								continue;
							}

							if (G[nx][ny] == 1 && !visited[nx][ny]) {
								visited[nx][ny] = true;
								Q.add(new Paint(nx, ny));
							}
						}
					} // while

					max = Math.max(max, size);

				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}

	static class Paint {
		int x;
		int y;

		public Paint(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}

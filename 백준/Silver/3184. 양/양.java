import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char[][] G;
	static boolean[][] visited;
	static int curSheep = 0;
	static int curWolf = 0;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Loc {
		int x;
		int y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			G[i] = br.readLine().toCharArray();
		}
		int resultSheep = 0;
		int resultWolf = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (G[i][j] != '#' && !visited[i][j]) {
					curSheep = 0;
					curWolf = 0;

					Queue<Loc> Q = new ArrayDeque<>();
					Q.add(new Loc(i, j));
					visited[i][j] = true;
					while (!Q.isEmpty()) {
						Loc cur = Q.poll();
						int x = cur.x;
						int y = cur.y;
						if (G[x][y] == 'o') {
							curSheep++;
						} else if (G[x][y] == 'v') {
							curWolf++;
						}

						for (int d = 0; d < 4; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];

							if (nx < 0 || ny < 0 || nx >= N || ny >= M || G[nx][ny] == '#' || visited[nx][ny]) {
								continue;
							}

							visited[nx][ny] = true;
							Q.add(new Loc(nx, ny));
						}

					} // end while
					if (curSheep > curWolf) {
						resultSheep += curSheep;
					} else {
						resultWolf += curWolf;
					}

				}

			}
		} // end for;
		System.out.println(resultSheep + " " + resultWolf);

	}

}

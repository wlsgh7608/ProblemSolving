import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		int[][] G = new int[N][N];
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int day = 0;

		while (true) {
			boolean isEnd = true;
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						Queue<int[]> q = new ArrayDeque<>();
						List<int[]> l = new ArrayList<>();
						q.add(new int[] { i, j });
						visited[i][j] = true;
						l.add(new int[] { i, j });
						int sum = 0;
						while (!q.isEmpty()) {
							int[] cur = q.poll();
							int x = cur[0];
							int y = cur[1];
							sum += G[x][y];
							for (int k = 0; k < 4; k++) {
								int nx = x + dx[k];
								int ny = y + dy[k];

								if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
									continue;

								int diff = Math.abs(G[nx][ny] - G[x][y]);
								if (min <= diff && diff <= max) {
									visited[nx][ny] = true;
									l.add(new int[] { nx, ny });
									q.add(new int[] { nx, ny });
								}

							}

						} // end while

						if (l.size() > 1) {
							isEnd = false;
							for (int[] point : l) {
								int x = point[0];
								int y = point[1];
								G[x][y] = (sum / l.size());
							}
						}

					}
				}
			}

			if (isEnd) {
				break;
			}
			day++;
		} // end inf loop
		System.out.println(day);

	}

}

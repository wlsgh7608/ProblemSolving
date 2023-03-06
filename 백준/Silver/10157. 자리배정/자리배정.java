import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		if (N * M < C) {
			sb.append(0);
		} else {
			int cnt = 0;
			int x = 0;
			int y = 0;
			int[] dx = { 1, 0, -1, 0 };
			int[] dy = { 0, 1, 0, -1 };
			int d = 0;
			boolean[][] visited = new boolean[M][N];
			while (cnt++ < C) {
				visited[x][y] = true;
				if (cnt == C) {
					sb.append((y + 1) + " " + (x + 1));
				}
				for (int i = 0; i < 4; i++) {
					int nd = (i + d) % 4;
					int nx = x + dx[nd];
					int ny = y + dy[nd];

					if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[nx][ny]) {
						continue;
					}
					x = nx;
					y = ny;
					d = nd;

				}

			}

		} // end else

		System.out.println(sb);
	}

}

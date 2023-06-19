import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Route {
		int x;
		int y;
		int t;

		public Route(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	static void dfs(int x, int y, int cnt) {

		if (cnt == K) {
			if (x == 0 && y == C - 1) {
				ans++;
			}

			return;

		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny] || G[nx][ny] == 'T') {
				continue;
			}

			visited[nx][ny] = true;
			dfs(nx, ny, cnt + 1);
			visited[nx][ny] = false;
		}

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int R, C, K;
	static int ans = 0;
	static char[][] G;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		G = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			G[i] = br.readLine().toCharArray();
		}

		// 시작 왼쪾 맨 아래
		visited[R-1][0]=true;
		dfs(R - 1, 0, 1);
		System.out.println(ans);

	}

}

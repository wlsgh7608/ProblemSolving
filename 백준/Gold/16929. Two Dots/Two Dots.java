import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char[][] G;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean[][] visited;

	static boolean isCycle(int x, int y, int px, int py) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M|| G[nx][ny]!=G[x][y]) {
				continue;
			}
			if (nx == px && ny == py) {
				continue;
			}
			if (visited[nx][ny]) {
				return true;
			}

			if (!visited[nx][ny]) {
				visited[nx][ny] = true;
				if (isCycle(nx, ny, x, y)) {
					return true;
				}
			}

		}
		return false;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		G = new char[N][M];
		for (int i = 0; i < N; i++) {
			G[i] = br.readLine().toCharArray();
		}
		boolean isTrue = false;
		for(int  i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(!visited[i][j]) {
					if(isCycle(i,j,-1,-1)) {
						isTrue = true;
					}
				}
			}
		}
		if(isTrue) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}

	}

}

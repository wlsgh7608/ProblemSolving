import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Jump {
		int x;
		int y;

		public Jump(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] G = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean isTrue = false;
		Queue<Jump> Q = new ArrayDeque<>();
		int[] dx = { 0, 1 };
		int[] dy = { 1, 0 };
		Q.add(new Jump(0, 0));
		while (!Q.isEmpty()) {
			Jump cur = Q.poll();
			int x = cur.x;
			int y = cur.y;
			int jump = G[x][y];
			if(jump==0) {
				continue;
			}

			if (x == N - 1 && y == N - 1) {
				isTrue = true;
				break;
			}

			for (int i = 0; i < 2; i++) {
				int nx = x + dx[i] * jump;
				int ny = y + dy[i] * jump;

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}
				Q.add(new Jump(nx, ny));
			}

		}
		if (isTrue) {
			System.out.println("HaruHaru");

		} else {
			System.out.println("Hing");
		}

	}

}

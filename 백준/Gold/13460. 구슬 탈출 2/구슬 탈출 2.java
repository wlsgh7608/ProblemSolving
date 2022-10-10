import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static final int FINAL = 10;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int result = 11;
	static int cnt=0;

	static char[][] copy(char[][] G) {
		char[][] newG = new char[N][M];
		for (int i = 0; i < N; i++) {
			newG[i] = G[i].clone();
		}

		return newG;
	}

	static boolean dfs(int depth, int d, Ball red, Ball blue, char[][] G) {
		cnt++;
		boolean isEnd = false;
		if (depth >= result) {
			return false;
		}
		int bx = blue.x;
		int by = blue.y;
		int rx = red.x;
		int ry = red.y;

		boolean redFirst = false;
		switch (d) {
		case 0:
			if (bx > rx) {
				redFirst = true;
			}
			break;
		case 1:
			if (bx < rx) {
				redFirst = true;
			}
			break;
		case 2:
			if (by > ry) {
				redFirst = true;
			}
			break;
		case 3:
			if (by < ry) {
				redFirst = true;
			}
			break;
		}

		char[][] newG = copy(G);

		Ball newRed = null;
		Ball newBlue = null;
		if (redFirst) {
			int nx = rx + dx[d];
			int ny = ry + dy[d];
			while (newG[nx][ny] == '.' || newG[nx][ny] == 'O') {
				if (newG[nx][ny] == 'O') {
					isEnd = true;
				}
				rx = nx;
				ry = ny;
				nx = rx + dx[d];
				ny = ry + dy[d];
			}
			newG[red.x][red.y] = '.';
			if (!isEnd) {
				newG[rx][ry] = 'R';
			}
//			for(char[] row : newG) {
//				System.out.println(Arrays.toString(row));
//			}
			nx = bx + dx[d];
			ny = by + dy[d];
			while (newG[nx][ny] == '.' || newG[nx][ny] == 'O') {
				if (newG[nx][ny] == 'O') {
					return false;
				}
				bx = nx;
				by = ny;
				nx = bx + dx[d];
				ny = by + dy[d];
			}
			newG[blue.x][blue.y] = '.';
			newG[bx][by] = 'B';
			newRed = new Ball(rx, ry);
			newBlue = new Ball(bx, by);
		} else {
			int nx = bx + dx[d];
			int ny = by + dy[d];
			while (newG[nx][ny] == '.' || newG[nx][ny] == 'O') {
				if (newG[bx][by] == 'O') {
					return false;
				}
				bx = nx;
				by = ny;
				nx = bx + dx[d];
				ny = by + dy[d];
			}
			newG[blue.x][blue.y] = '.';
			newG[bx][by] = 'B';

			nx = rx + dx[d];
			ny = ry + dy[d];
			while (newG[nx][ny] == '.' || newG[nx][ny] == 'O') {
				if (newG[nx][ny] == 'O') {
					isEnd = true;
				}
				rx = nx;
				ry = ny;
				nx = rx + dx[d];
				ny = ry + dy[d];
			}
			newG[red.x][red.y] = '.';
			if (!isEnd) {
				newG[rx][ry] = 'R';
			}
			newRed = new Ball(rx, ry);
			newBlue = new Ball(bx, by);
		}

		
		if(isEnd) {
			result = Math.min(result, depth);
			return true;
		}

		for (int i = 0; i < 4; i++) {
			dfs(depth + 1, i, newRed, newBlue, newG);
		}

		return true;
	}

	static class Ball {
		int x;
		int y;

		public Ball(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Ball [x=" + x + ", y=" + y + "]";
		}
		

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] G = new char[N][M];

		Ball r = null;
		Ball b = null;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				G[i][j] = input.charAt(j);
				if (G[i][j] == 'R') {
					r = new Ball(i, j);
				} else if (G[i][j] == 'B') {
					b = new Ball(i, j);
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			dfs(1, i, r, b, G);
		}
		if(result==11) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}

	}

}

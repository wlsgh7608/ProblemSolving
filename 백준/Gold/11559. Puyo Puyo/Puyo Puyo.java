import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
	static char[][] map;
	static int R = 12;
	static int C = 6;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean find() {

		boolean flag = false;
		boolean[][] visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '.' && !visited[i][j]) {
					Queue<int[]> Q = new ArrayDeque<>();
					List<int[]> l = new ArrayList<>();
					Q.add(new int[] { i, j });
					l.add(new int[] { i, j });
					char color = map[i][j];
					visited[i][j] = true;

					while (!Q.isEmpty()) {
						int[] cur = Q.poll();
						int x = cur[0];
						int y = cur[1];

						for (int p = 0; p < 4; p++) {
							int nx = x + dx[p];
							int ny = y + dy[p];

							if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny]) {
								continue;
							}

							if (map[nx][ny] == color) {
								visited[nx][ny] = true;
								Q.add(new int[] { nx, ny });
								l.add(new int[] { nx, ny });
							}

						}
					}
					if (l.size() >= 4) {
						flag = true;
						for (int[] cur : l) {
							int x = cur[0];
							int y = cur[1];
							map[x][y] = '.';
						}
					}

				}
			}
		}

		return flag;
	}

	static void lower() {
		for(int c = 0; c<C;c++) {
			int idx =  R-1;
			for(int r =R-1;r>=0;r-- ) {
				if(map[r][c] !='.') {
					char temp = map[r][c];
					map[r][c] = '.';
					map[idx][c] = temp;
					idx--;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int t = 0;
		while (true) {
			if (find()) {
				t++;
				lower();
			}else {
				break;
			}
		}

		System.out.println(t);
	}

}

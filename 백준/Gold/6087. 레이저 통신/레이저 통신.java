import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Lazer implements Comparable<Lazer> {
		int x;
		int y;
		int d;
		int cnt;

		public Lazer(int x, int y, int d, int cnt) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Lazer o) {
			return this.cnt - o.cnt;
		}

		@Override
		public String toString() {
			return "Lazer [x=" + x + ", y=" + y + ", d=" + d + ", cnt=" + cnt + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		char[][] G = new char[H][W];
		int[][] tot = new int[H][W];
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };

		for (int[] row : tot) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		int startX = -1;
		int startY = -1;
		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			for (int j = 0; j < W; j++) {
				G[i][j] = str.charAt(j);
				if (G[i][j] == 'C') {
					startX = i;
					startY = j;
				}
			}
		}
		PriorityQueue<Lazer> PQ = new PriorityQueue<>();
		for (int i = 0; i < 4; i++) {
			PQ.add(new Lazer(startX, startY, i, 0));
		}
		tot[startX][startY] = 0;

		while (!PQ.isEmpty()) {
			Lazer cur = PQ.poll();
//			System.out.println(cur);
			int x = cur.x;
			int y = cur.y;
			int cnt = cur.cnt;

			if ((x != startX || y != startY) && G[x][y] == 'C') {

				System.out.println(cnt);
				break;
			}

			for (int i = 0; i < 4; i++) {
				if (i == 2) {
					continue;
				}
				int d = (cur.d + i) % 4;
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || ny < 0 || nx >= H || ny >= W || G[nx][ny] == '*') {
					continue;
				}

				if (cur.d == d) {
					if (tot[nx][ny] >= cnt) {
						tot[nx][ny] = cnt;
						PQ.add(new Lazer(nx, ny, d, cnt));
					}
					
				} else {
					if (tot[nx][ny] >= cnt + 1) {
						tot[nx][ny] = cnt+1;
						PQ.add(new Lazer(nx, ny, d, cnt+1));
					}
				}

			}

		}

	}

}


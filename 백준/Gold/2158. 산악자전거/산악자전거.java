import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Bike implements Comparable<Bike> {
		int x;
		int y;
		double v;
		double time;

		public Bike(int x, int y, double v, double time) {
			super();
			this.x = x;
			this.y = y;
			this.v = v;
			this.time = time;
		}

		@Override
		public int compareTo(Bike o) {
			return Double.compare(this.time, o.time);
		}

		@Override
		public String toString() {
			return "Bike [x=" + x + ", y=" + y + ", v=" + v + ", time=" + time + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] G = new int[R][C];
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		double[][] dist = new double[R][C];
		double[][] velo = new double[R][C];
		PriorityQueue<Bike> PQ = new PriorityQueue<>();

		for (double[] row : dist) {
			Arrays.fill(row, Double.MAX_VALUE);
		}
		dist[0][0] = 0;
		velo[0][0] = V;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		PQ.add(new Bike(0, 0, V, 0.0));
		while (!PQ.isEmpty()) {
			Bike cur = PQ.poll();
			int x = cur.x;
			int y = cur.y;
			double t = cur.time;
			double v = cur.v;

			if (x == R - 1 && y == C - 1) {
				System.out.printf("%.2f", t);
				break;
			}

			for (int d = 0; d < 4; d++) {
				double dt = 0;

				int nx = x + dx[d];
				int ny = y + dy[d];
				dt += (1.0 / v);
				if (nx == -1 || ny == -1 || nx == R || ny == C) {
					continue;
				}
				double nv = v*Math.pow(2, (G[x][y] - G[nx][ny]));
				if (t + dt < dist[nx][ny]) {
					Bike nb = new Bike(nx, ny, nv, dist[nx][ny]);
					dist[nx][ny] = t + dt;
					velo[nx][ny] = nv;
					PQ.add(new Bike(nx, ny, nv, dist[nx][ny]));
				}
				if (velo[nx][ny] > nv) {
					velo[nx][ny] = nv;
					PQ.add(new Bike(nx, ny, nv, t + dt));
				}

			}

		}

	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Airport implements Comparable<Airport> {
		int vertex;
		int cost;
		int time;

		public Airport(int vertex, int cost, int time) {
			super();
			this.vertex = vertex;
			this.cost = cost;
			this.time = time;
		}

		@Override
		public int compareTo(Airport o) {
			return this.time - o.time;
		}

		@Override
		public String toString() {
			return "Airport [vertex=" + vertex + ", cost=" + cost + ", time=" + time + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			ArrayList<ArrayList<Airport>> adjList = new ArrayList<>();
			for (int i = 0; i < N + 1; i++) {
				adjList.add(new ArrayList<>());
			}
			int[][] dp = new int[N + 1][M + 1];

			for (int[] row : dp) {
				Arrays.fill(row, Integer.MAX_VALUE);
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				adjList.get(u).add(new Airport(v, c, d));
			}
			PriorityQueue<Airport> pq = new PriorityQueue<>();
			pq.add(new Airport(1, 0, 0));

			int result = -1;
			while (!pq.isEmpty()) {
				Airport cur = pq.poll();
				if (cur.vertex == N) {
					if (cur.cost <= M) {
						result = cur.time;
						break;
					}
					continue;
				}
				for (Airport next : adjList.get(cur.vertex)) {
					int nc = cur.cost + next.cost;
					int nt = cur.time + next.time;

					if (nc <= M && nt < dp[next.vertex][nc]) {
						dp[next.vertex][nc] = nt;
						pq.add(new Airport(next.vertex, nc, nt));
					}
				}
			}
			if (result != -1) {
				sb.append(result).append("\n");
			} else {
				sb.append("Poor KCM").append("\n");
			}
		}

		// end for
		System.out.println(sb);
	}
}

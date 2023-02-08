import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Jump {
		int v;
		int cnt;

		public Jump(int v, int cnt) {
			super();
			this.v = v;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dist = new int[N + 1];
		Arrays.fill(dist, 100_000);

		dist[1] = 0;

		Queue<Jump> Q = new ArrayDeque<>();
		Q.add(new Jump(1, 0));
		while (!Q.isEmpty()) {
			Jump cur = Q.poll();
			int jump = arr[cur.v];
			if (cur.v == N) {
				break;
			}

			for (int i = 1; i <= jump; i++) {
				int next = cur.v + i;
				if (next <= N && dist[next] > cur.cnt + 1) {
					dist[next] = cur.cnt + 1;
					Q.add(new Jump(next, dist[next]));
				}
				next = cur.v - i;
				if (next > 0 && dist[next] > cur.cnt + 1) {
					dist[next] = cur.cnt + 1;
					Q.add(new Jump(next, dist[next]));
				}
			}
		}
		
		if (dist[N] == 100_000) {
			dist[N] = -1;
		}
		System.out.println(dist[N]);

	}

}


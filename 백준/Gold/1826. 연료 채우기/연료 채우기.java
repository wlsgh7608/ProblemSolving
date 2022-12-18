import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Gas implements Comparable<Gas> {
		int v;
		int w;

		public Gas(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Gas o) {
			return this.v - o.v;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Gas[] g = new Gas[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[i] = new Gas(a, b);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int gasIdx = 0;
		PriorityQueue<Integer> possible = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int cnt = 0;
		Arrays.sort(g);
		while (P < L) {
			while (gasIdx < g.length && g[gasIdx].v <= P) {
				possible.add(g[gasIdx].w);
				gasIdx++;
			}
			if (possible.isEmpty()) {
				cnt = -1;
				break;
			} else {
				P += possible.poll();
				cnt++;
			}

		}
		System.out.println(cnt);

	}

}

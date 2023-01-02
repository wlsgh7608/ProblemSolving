import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Road implements Comparable<Road> {
		int v;
		int n;
		int w;

		public Road(int v, int n, int w) {
			super();
			this.v = v;
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Road o) {
			return this.w - o.w;
		}
	}

	static void union(int a, int b) {
		if (isDev[a]) {
			parent[b] = a;
		} else if (isDev[b]) {
			parent[a] = b;
		} else {
			parent[a] = b;
		}

	}

	static int getParent(int v) {
		if (parent[v] == v) {
			return v;
		}
		return parent[v] = getParent(parent[v]);

	}

	static int[] parent;
	static boolean[] isDev;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		isDev = new boolean[N + 1];
		parent = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(st.nextToken());
			isDev[n] = true;
		}
		List<Road> adjList[] = new List[N + 1];

		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
			parent[i] = i;
		}

		PriorityQueue<Road> PQ = new PriorityQueue<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[u].add(new Road(u, v, w));
			adjList[v].add(new Road(v, u, w));
			PQ.add(new Road(u, v, w));
		}

		int ans = 0;
		while (!PQ.isEmpty()) {
			Road cur = PQ.poll();
			int a = cur.n;
			int b = cur.v;
			int w = cur.w;

			int parentA = getParent(a);
			int parentB = getParent(b);
			boolean isDev_A = isDev[parentA];
			boolean isDev_B = isDev[parentB];

			if ((!isDev_A || !isDev_B) && (parentA != parentB)) {
				union(parentA, parentB);
				ans += w;
			}
		}
		System.out.println(ans);

	}

}

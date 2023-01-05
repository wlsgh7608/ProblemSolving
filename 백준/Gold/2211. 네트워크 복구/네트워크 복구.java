import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Network implements Comparable<Network> {

		int v;
		int w;

		public Network(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Network o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Network [v=" + v + ", w=" + w + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Network>[] adjList = new List[N + 1];
		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adjList[a].add(new Network(b, w));
			adjList[b].add(new Network(a, w));

		}
		int[] dist = new int[N + 1];
		int[] prev = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		PriorityQueue<Network> PQ = new PriorityQueue<>();
		PQ.add(new Network(1, 0));
		List<Network> l = new ArrayList<>();

		while (!PQ.isEmpty()) {
			Network cur = PQ.poll();
			l.add(cur);

			for (Network next : adjList[cur.v]) {
				if (cur.w + next.w < dist[next.v]) {
					dist[next.v] = cur.w + next.w;
					prev[next.v]= cur.v; 
					PQ.add(new Network(next.v, dist[next.v]));
				}
			}
		}
		
		System.out.println(N-1);
		for(int i = 2; i<=N;i++) {
			System.out.println(i+" "+prev[i]);
		}


	}

}
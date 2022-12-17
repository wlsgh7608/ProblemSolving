import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Move implements Comparable<Move> {
		int v;
		int w;

		public Move(int e, int w) {
			super();
			this.v = e;
			this.w = w;
		}

		@Override
		public int compareTo(Move o) {
			return o.w - this.w;
		}

		@Override
		public String toString() {
			return "Move [v=" + v + ", w=" + w + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		List<Move>[] adjList = new List[p];
		for (int i = 0; i < p; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adjList[s].add(new Move(e, v));
			adjList[e].add(new Move(s, v));
		}
		int[] maxWidth = new int[p];
		PriorityQueue<Move> PQ = new PriorityQueue<>();
		PQ.add(new Move(B, Integer.MAX_VALUE));
		while (!PQ.isEmpty()) {
			Move cur = PQ.poll();
			if (cur.v == C) {
				System.out.println(cur.w);
				break;
			}
			for (Move next : adjList[cur.v]) {
				int curMin = Math.min(next.w, cur.w);
				if (maxWidth[next.v] < curMin) {
					maxWidth[next.v] = curMin;
					PQ.add(new Move(next.v, curMin));
				}
			}
		}

	}

}

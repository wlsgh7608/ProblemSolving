import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Cow implements Comparable<Cow> {
		int b;
		int c;

		public Cow(int b, int c) {
			super();
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Cow o) {
			return this.c - o.c;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		List<Cow>[] adjList = new List[N+1];
		
		for(int i =1;i<N+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			adjList[A].add(new Cow(B,C));
			adjList[B].add(new Cow(A,C));
			
		}
		int [] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1]= 0 ;
		
		PriorityQueue<Cow> PQ = new PriorityQueue<>();
		PQ.add(new Cow(1,0));
		while(!PQ.isEmpty()) {
			Cow cur = PQ.poll();
			
			for(Cow next : adjList[cur.b]) {
				if(dist[next.b]> cur.c+next.c) {
					dist[next.b] = cur.c+next.c;
					PQ.add(new Cow(next.b,dist[next.b]));
				}
			}
		}
		System.out.println(dist[N]);
		
		
		
	}
}

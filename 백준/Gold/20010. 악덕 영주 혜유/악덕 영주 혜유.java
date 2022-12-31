import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	
	static int[] parent;
	static int N;
	static int M;
	
	
	static int getParent(int v) {
		if(parent[v] ==v) {
			return v;
		}
		return parent[v] = getParent(parent[v]);	
	}
	
	static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		parent[a] = b;
		
	}
	
	static class Street implements Comparable<Street>{
		int a;
		int b;
		int v;
		
		public Street(int a, int b, int v) {
			super();
			this.a = a;
			this.b = b;
			this.v = v;
		}

		@Override
		public int compareTo(Street o) {
			return this.v-o.v;
		}
		
	}
	
	static class Road{
		int v;
		int w;
		public Road(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		parent = new int[N];
		List<Road>[] adjList = new List[N];
		
		PriorityQueue<Street> PQ = new PriorityQueue<>();
		for(int i = 0; i<N;i++) {
			parent[i] = i;
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			PQ.add(new Street(a, b, v));
		}
		
		
		int tot = 0;
		int max = 0;
		while(!PQ.isEmpty()) {
			Street cur = PQ.poll();
			int a = cur.a;
			int b = cur.b;
			int parentA = getParent(cur.a);
			int parentB = getParent(cur.b);
			if(parentA!=parentB) {
				union(a,b);
				adjList[a].add(new Road(b,cur.v));
				adjList[b].add(new Road(a,cur.v));
				tot += cur.v;
			}
		}
		
		for(int i = 0; i<N;i++) {
			Queue<Road> Q = new ArrayDeque();
			boolean[] visited = new boolean[N];
			visited[i] = true;
			Q.add(new Road(i,0));
			int curMax = 0;
			while(!Q.isEmpty()) {
				Road cur = Q.poll();
				int v= cur.v;
				int w = cur.w;
				curMax = Math.max(curMax, w);
				for(Road next : adjList[v]) {
					if(!visited[next.v]) {
						visited[next.v]= true;
						Q.add(new Road(next.v,next.w+w));
					}
				}
			}
			max = Math.max(max, curMax);
		}	
		
		
		System.out.println(tot);
		System.out.println(max);
		
		
		
	}

}

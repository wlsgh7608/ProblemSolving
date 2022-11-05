import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		long x;
		long y;
		public Point(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static class Dist implements Comparable<Dist>{
		int s;
		int e;
		double d;
		
		public Dist(int s, int e, double d) {
			super();
			this.s = s;
			this.e = e;
			this.d = d;
		}
		public int compareTo(Dist o) {
			return Double.compare(this.d,o.d); 
		}
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a<b) {
			parent[b]= a;
		}else {
			parent[a] =b;
		}
		
	}
	
	
	static int find(int a) {
		if(parent[a]!=a) {
			return parent[a] = find(parent[a]);
		}
		return a;
	}
	
	static double getD(Point a , Point b) {
		long x = a.x-b.x;
		long y = a.y-b.y;
		
		return Math.sqrt(x*x+y*y);
		
	}
	
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Point[] p = new Point[N+1];
		parent = new int[N+1];
		for(int i = 1;i<N+1;i++) {
			parent[i] = i;
		}
		for(int i = 1; i<N+1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());
			p[i] = new Point(x,y);
		}
		double result = 0.0;
		
		for(int i =0; i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			a = find(a);
			b = find(b);
			
			if(a !=b) {
				union(a,b);
			}
		}
		PriorityQueue<Dist> PQ = new PriorityQueue<>();
		for(int i = 1; i<N+1;i++) {
			for(int j = i+1 ;j<N+1;j++) {
				if(parent[i]!=parent[j]) {
					double d = getD(p[i],p[j]);
					PQ.add(new Dist(i,j,d));
				}
			}
		}
		
		while(!PQ.isEmpty()) {
			Dist d = PQ.poll();
			int s = find(d.s);
			int e = find(d.e);
			
			if(s!=e) {
				union(s, e);
				result+=d.d;
			}
		}
		System.out.printf("%.2f",result);
	}

}

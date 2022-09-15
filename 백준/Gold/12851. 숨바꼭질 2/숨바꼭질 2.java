import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int cnt;
		int l;
		public Node(int cnt, int l) {
			super();
			this.cnt = cnt;
			this.l = l;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cnt-o.cnt;
		}
		
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dist = new int [200001];
		Arrays.fill(dist,Integer.MAX_VALUE);
		
		dist[N] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0,N));
		int ans = Integer.MAX_VALUE;
		int cnt=0;
		
		while (! pq.isEmpty()) {
			Node cur = pq.poll();
			int x = cur.l;
			int c = cur.cnt;
			if (cur.l == K && cur.cnt<=ans) {
				ans = cur.cnt;
				cnt++;
			}
			else {
				if(x+1<=100000 && dist[x+1]>= c+1) {
					dist[x+1] = c+1;
					pq.add(new Node(c+1,x+1));
				}
				if(x-1>=0 && dist[x-1]>= c+1) {
					dist[x-1] = c+1;
					pq.add(new Node(c+1,x-1));
				}
				if(x*2<=200000 && dist[x*2]>= c+1) {
					dist[x*2] = c+1;
					pq.add(new Node(c+1,x*2));
				}
				
			}
		}
		System.out.println(ans);
		System.out.println(cnt);
		
		
		

	}

}

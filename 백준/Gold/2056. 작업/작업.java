import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Work implements Comparable<Work>{
		int time;
		int n;
		public Work(int time, int n) {
			super();
			this.time = time;
			this.n = n;
		}
		
		@Override
		public int compareTo(Work o) {
			return this.time-o.time;
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] adjList = new ArrayList[N+1];
		int[] times = new int[N+1];
		for(int i = 0; i<N+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		int[]  cnt = new int[N+1];
		
		for(int i = 1; i<N+1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int t = Integer.parseInt(st.nextToken());
			times[i] = t;
			
			int n = Integer.parseInt(st.nextToken());
			cnt[i] =n;
			for(int j = 0; j<n;j++) {
				int before = Integer.parseInt(st.nextToken());
				adjList[before].add(i);
			}
		}
		PriorityQueue<Work> pq = new PriorityQueue<>();
		
		int[] dp = new int[N+1];
		for(int i = 1;i<N+1;i++) {
			if(cnt[i]==0) {
				pq.add(new Work(times[i],i));
				dp[i] = times[i];
			}
		}
		int result = 0;
		while(!pq.isEmpty()) {
			Work cur = pq.poll();
			for(int next : adjList[cur.n]) {
				dp[next] = Math.max(dp[next], dp[cur.n]+times[next]);
				result = Math.max(dp[next],result);
				if(--cnt[next]== 0) {
					pq.add(new Work(times[next],next));
				}
			}
		}
		for(int i =1 ;i<N+1;i++) {
			result = Math.max(dp[i], result);
		}
		System.out.println(result);
	}
}

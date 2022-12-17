import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Use implements Comparable<Use> {
		int n;
		int e;

		public Use(int n, int e) {
			super();
			this.n = n;
			this.e = e;
		}

		@Override
		public int compareTo(Use o) {
			return this.e - o.e;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int[][] times = new int[N][2];

		for(int i = 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			times[i] = new int[]{P,Q};
		}
		Arrays.sort(times,(a,b)->a[0]-b[0]);
		
		int maxN = 0;
		PriorityQueue<Integer> possible = new PriorityQueue<>();
		PriorityQueue<Use> running = new PriorityQueue<>();
		int[] cnt = new int[N];
		for(int[] row: times) {
			int  time  = row[0];
			int endTime = row[1];
			while(!running.isEmpty() && running.peek().e<time) {
				possible.add(running.poll().n);
			}
			
			if(possible.isEmpty()) {
				possible.add(maxN);
				maxN++;
			}
			int useN = possible.poll();
			cnt[useN]++;
			running.add(new Use(useN,endTime));
		}
		StringBuilder sb = new StringBuilder();
		for(int n: cnt) {
			if(n==0) {
				break;
			}
			sb.append(n+" ");
		}
		System.out.println(maxN);
		System.out.println(sb);
		
		
		
		
		
		
		
		
	}

}

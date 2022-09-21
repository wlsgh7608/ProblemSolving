import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Lecture implements Comparable<Lecture>{
		int s;
		int e;
		public Lecture(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}
		
		@Override
		public int compareTo(Lecture o) {
			if(this.s== o.s) {
				return this.e-o.e;
			}
			return this.s-o.s;
		}

		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Lecture[] l = new Lecture[N];
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			l[i] = new Lecture(s, e);
		}
		Arrays.sort(l);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(l[0].e);
		for(int i = 1;i<N;i++) {
			if(pq.peek() <= l[i].s) {
				pq.poll();
			}
			pq.add(l[i].e);
		}
		System.out.println(pq.size());
		
		
	}

}

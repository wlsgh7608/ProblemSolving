import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Info implements Comparable<Info> {
		int s;
		int e;
		int n;

		public Info(int s, int e,int n) {
			super();
			this.s = s;
			this.e = e;
			this.n = n;
		}

		@Override
		public int compareTo(Info o) {
			if (this.e == o.e) {
				return this.s - o.s;
			}
			return this.e - o.e;
		}

		@Override
		public String toString() {
			return "Info [s=" + s + ", e=" + e + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Info[] arr = new Info[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Info(a, b,i+1);
		}
		Arrays.sort(arr,(o1,o2)->o1.s-o2.s);
		PriorityQueue<Info> PQ = new PriorityQueue<>();
		int maxSize = 0;
		int maxLoc = -1;
		for(int i = 0; i<N;i++) {
			int cur = arr[i].s;
			PQ.add(arr[i]);
			while(!PQ.isEmpty()&& PQ.peek().e < cur) {
				PQ.poll();
			}
			if(maxSize<PQ.size()) {
				maxSize = PQ.size();
				maxLoc = cur;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(maxSize).append("\n");
		for(Info info : arr) {
			if(info.s<=maxLoc&&maxLoc<=info.e) {
				sb.append(info.n+" ");
			}
		}
		System.out.println(sb);

	}
}

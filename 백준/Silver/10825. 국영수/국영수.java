import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Score implements Comparable<Score> {
		String name;
		int k;
		int e;
		int m;

		public Score(String name, int k, int e, int m) {
			this.name = name;
			this.k = k;
			this.e = e;
			this.m = m;
		}

		@Override
		public int compareTo(Score o) {
			if (this.k == o.k) {
				if (this.e == o.e) {
					if (o.m == this.m) {
						return this.name.compareTo(o.name);
					}
					return o.m - this.m;
				}
				return this.e - o.e;
			}
			return o.k - this.k;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Score[] s = new Score[N];
		for(int i = 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int k = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			s[i] = new Score(name,k,e,m);
		}
		Arrays.sort(s);
		
		for(Score sc : s) {
			sb.append(sc.name).append("\n");
		}
		System.out.println(sb);
		
		

	}

}

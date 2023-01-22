import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Country implements Comparable<Country> {
		int n;
		int g;
		int s;
		int b;
		
		
		

		public Country(int n, int g, int s, int b) {
			super();
			this.n = n;
			this.g = g;
			this.s = s;
			this.b = b;
		}



		@Override
		public int compareTo(Country o) {
			if (o.g == this.g) {
				if (o.s == this.s) {
					return o.b - this.b;
				}
				return o.s - this.s;
			}

			return o.g - this.g;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Country> l = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			l.add(new Country(n,g,s,b));
		}
		Collections.sort(l);
		Country pre = null;
		int rank = 1;
		
		for(int i = 0; i<N;i++) {
			Country cur = l.get(i);
			if(pre==null||(cur.g == pre.g && cur.s == pre.s &&cur.b==pre.b)) {
				
			}else {
				rank = i+1;
			}
//			System.out.println(cur.n);
			if(cur.n == K) {
				System.out.println(rank);
			}
			pre = cur;
		}
		

	}

}

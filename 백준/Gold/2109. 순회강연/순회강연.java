import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Pay {
		int p;
		int d;

		public Pay(int p, int d) {
			super();
			this.p = p;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Pay [p=" + p + ", d=" + d + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int max_d = 0;
		Pay[] pays = new Pay[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pays[i] = new Pay(p,d);
			max_d = d > max_d ? d : max_d;
		}
		
		boolean[] isUses = new boolean[N];
		int result = 0;
		for(int i = max_d;i>0;i--) {
			int max_idx = -1;
			int max_pay = 0;
			for(int j = 0; j<N;j++) {
				if (!isUses[j] && pays[j].d>=i && pays[j].p>max_pay) {
					max_idx = j;
					max_pay = pays[j].p;
				}
			}
			if(max_idx!=-1) {
				isUses[max_idx]= true;
				result+=max_pay;
			}
			
		}
		System.out.println(result);
		
		
	}

}

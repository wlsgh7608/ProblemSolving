import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Work{
		int d;
		int p;
		public Work(int d, int p) {
			super();
			this.d = d;
			this.p = p;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Work[] works = new Work[N];
		int [] dp = new int[N+1];
		for(int i = 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int d = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			if(i+d<=N) {
					dp[i+d] = Math.max(dp[i]+p,dp[i+d]);
				
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		System.out.println(dp[N]);
		
		
	}

}

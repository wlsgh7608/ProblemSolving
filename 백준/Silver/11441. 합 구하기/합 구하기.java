import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1]; 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ;i<N+1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long[] dp = new long[N+1];
		for(int i = 1; i<=N;i++) {
			dp[i] = dp[i-1]+arr[i];
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(dp[b]-dp[a-1]).append("\n");
		}
		System.out.println(sb);
		
		
	}

}

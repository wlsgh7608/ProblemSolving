import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		
		for(int i = 0;i<N;i++) {
			dp[i] = arr[i];
			for(int j = i-1;j>=0;j--) {
				if(arr[j]<arr[i]) {
					dp[i] =  Math.max(dp[i], dp[j]+arr[i]);
				}
			}
		}
		
		int max = 0;
		for(int n: dp) {
			max = Math.max(max, n);
		}
		System.out.println(max);
	}

}

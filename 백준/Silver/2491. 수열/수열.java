import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] dp1 = new int[N];
		int[] dp2 = new int[N];
		
		int len = 0;
		for(int i = 0 ; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1;i <N;i++) {
			if(arr[i]>=arr[i-1]) {
				dp1[i] = dp1[i-1]+1;
				len = Math.max(len, dp1[i]);
			}
		}
		
		for(int i = 1;i <N;i++) {
			if(arr[i]<=arr[i-1]) {
				dp2[i] = dp2[i-1]+1;
				len = Math.max(len, dp2[i]);
			}
		}
		
		System.out.println(len+1);
		
		
		
	}

}

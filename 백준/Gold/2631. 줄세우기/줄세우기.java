import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static int get_idx(int target) {
		
		int lo = 0;
		int hi = lis.size()-1;
		while(lo<=hi) {
			int m = (lo+hi)/2;
			if(lis.get(m)>=target) {
				hi = m - 1;
			}else {
				lo = m+1;
			}
		}
		return lo;
	}
	
	static int [] arr;
	static List<Integer> lis;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		final int MAX_CNT = 205;
		arr = new int[N+1];
		int[] dp = new int[N+1];
		Arrays.fill(dp, MAX_CNT);
		dp[0] = 0;
		lis = new ArrayList<>();
		
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			int idx = get_idx(arr[i]);
			if(idx==lis.size()){
				lis.add(arr[i]);
			}else {
				lis.set(idx, arr[i]);
			}
		}
		System.out.println(N-lis.size());
		
	}
}

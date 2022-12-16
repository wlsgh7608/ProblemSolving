import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] cnt = new int [1_000_001];
		int[] ans = new int [N];
		
		Stack<Integer> S = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i =0 ; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			cnt[arr[i]]++;
		}
		
		
		
		for (int i = 0; i<N;i++) {
			if(S.isEmpty()) {
				S.add(i);
				continue;
			}
			int cur_cnt  = cnt[arr[i]];
			while(!S.isEmpty()) {
				int peek_n = arr[S.peek()];
				if(cnt[peek_n] >= cur_cnt) {
					break;
				}
				int idx = S.pop();
				ans[idx] = arr[i];
			}
			S.add(i);
		}
		
		while(!S.isEmpty()) {
			int idx = S.pop();
			ans[idx] = -1;
		}
		for(int n : ans) {
			sb.append(n+" ");
		}
		System.out.println(sb);
		
		
	}
	
	

}

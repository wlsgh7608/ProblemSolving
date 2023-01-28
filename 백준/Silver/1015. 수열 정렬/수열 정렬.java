import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] cnt  = new int[1001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		for(int i = 0; i<N;i++) {
			int cur = arr[i];
			cnt[cur]++;
		}
		
		for(int i = 1; i<1001;i++) {
			cnt[i] += cnt[i-1];
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<N;i++) {
			int cur = arr[i];
			sb.append(cnt[cur-1]++).append(" ");
		}
		System.out.println(sb);
		
	}
}

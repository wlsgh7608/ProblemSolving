import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int newN = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		if (N > 0) {
			st = new StringTokenizer(br.readLine());
		}
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		int ans = 1;
		int same = -1;
		boolean isSame = false;
		for(int i= 1; i<=N;i++) {
			if(arr[i]<newN) {
				ans = i;
				break;
			}
			if(arr[i] == newN && !isSame) {
				isSame = true;
				same = i;
			}
			ans++;
		}
		if(isSame && ans<=P) {
			ans = same;
		}
		if(ans>P) {
			ans = -1;
		}
		System.out.println(ans);

	}
}

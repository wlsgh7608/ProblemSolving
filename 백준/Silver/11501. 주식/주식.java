import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			long[] arr = new long[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			int p = N - 1;

			long max = 0;
			long result = 0;
			for (int i = p; i >= 0; i--) {
				if (max > arr[i]) {
					result += max - arr[i];
				} else {
					max = arr[i];
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}

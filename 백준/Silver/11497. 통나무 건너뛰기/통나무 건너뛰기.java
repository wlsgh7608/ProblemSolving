import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int[] result = new int[N];

			Arrays.sort(arr);
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					result[i / 2] = arr[i];
				} else {
					result[N - 1 - i / 2] = arr[i];
				}
			}

			int max = 0;
			for (int i = 1; i < N; i++) {
				max = Math.max(max, Math.abs(result[i] - result[i - 1]));
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}

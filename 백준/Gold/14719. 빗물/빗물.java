import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[W];
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		for (int i = 1; i < W - 1; i++) {
			int prev = 0;
			int next = 0;
			for (int j = 0; j < i; j++) {
				prev = Math.max(prev, arr[j]);
			}
			for (int j = i + 1; j < W; j++) {
				next = Math.max(next, arr[j]);
			}

			int v = Math.min(prev, next);
			if (arr[i] < v) {
				result += v - arr[i];
			}
		}
		System.out.println(result);

	}

}

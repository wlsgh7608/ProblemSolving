import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static void dfs(int depth, int flag) {
		if (depth == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += arr[selected[i]];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					result[i] = arr[selected[i]];
				}
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if ((flag & 1 << i) == 0) {
				selected[depth] = i;
				dfs(depth + 1, flag | 1 << i);
			}
		}

	}

	static int[] arr;
	static int[] selected;
	static int[] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[9];
		result = new int[7];
		selected = new int[7];

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dfs(0, 0);
		Arrays.sort(result);
		StringBuilder sb = new StringBuilder();
		for (int n : result) {
			sb.append(n).append("\n");
		}
		System.out.println(sb);

	}

}

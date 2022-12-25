import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] sel;
	static int ans = 0;

	static void comb(int depth) {
		if (depth == 10) {
			int cnt = 0;
			for (int i = 0; i < 10; i++) {
				if (arr[i] == sel[i]) {
					cnt++;
				}
			}

			if (cnt >= 5) {
				ans++;
			}
			return;
		}

		for (int j = 1; j < 6; j++) {
			if (depth >= 2 && sel[depth - 1] == j && sel[depth - 2] == j) {
				continue;
			}
			sel[depth] = j;
			comb(depth + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[10];
		sel = new int[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		comb(0);
		System.out.println(ans);

	}

}

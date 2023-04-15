import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static void perm(int depth, int flag) {
		if (depth == N) {

			for (int n : loc) {
				System.out.print(n + " ");
			}
			isAns = true;
			return;
		}
		for (int i = 1; i <= N; i++) {
			if ((flag & 1 << i) == 0) {
				int cnt = 0;
				for (int j = 0; j < depth; j++) {
					if (loc[j] > i) {
						cnt++;
					}
				}
				if (cnt == arr[i]) {
					loc[depth] = i;
					perm(depth + 1, flag | 1 << i);
					if (isAns) {
						return;
					}

				}

			}

		}

	}

	static int N;
	static int[] loc;
	static int[] arr;
	static boolean isAns = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		loc = new int[N];

		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0) {
				loc[0] = i;
				perm(1, 1 << i);
			}
		}

	}
}

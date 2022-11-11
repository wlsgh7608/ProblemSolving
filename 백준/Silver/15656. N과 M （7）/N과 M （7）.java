import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int N;
	static int M;
	static int[] n_list;
	static StringBuilder sb = new StringBuilder();

	static void perm(int depth, int flag) {
		if (depth == M) {
			for (int n : n_list) {
				sb.append(n + " ");
			}
			sb.append("\n");

			return;
		}
		for (int i = 0; i < N; i++) {
			n_list[depth] = arr[i];
			perm(depth + 1, flag | 1 << i);

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		n_list = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(0, 0);
		System.out.println(sb);

	}

}

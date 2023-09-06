import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static long calc(long a, long b) {
		return a * b % 1_000_000_007;

	}

	static long init(int no, int leftC, int rightC) {
		if (leftC == rightC) {
			return tree[no] = arr[leftC];
		}
		int mid = (leftC + rightC) / 2;
		long left = init(no * 2, leftC, mid);
		long right = init(no * 2 + 1, mid + 1, rightC);
		return tree[no] = calc(left, right);
	}

	static long update(int u, long n, int no, int leftC, int rightC) {
		if (u < leftC || u > rightC) {
			return tree[no];
		}

		if (leftC == rightC) {
			tree[no] = n;
			return tree[no];
		}
		int mid = (leftC + rightC) / 2;
		long left = update(u, n, no * 2, leftC, mid);
		long right = update(u, n, no * 2 + 1, mid + 1, rightC);
		return tree[no] = calc(left, right);

	}

	static long query(int ql, int qr, int no, int leftC, int rightC) {
		if (qr < leftC || ql > rightC) {
			return 1;
		}
		if (ql <= leftC && qr >= rightC) {
			return tree[no];
		}
		int mid = (leftC + rightC) / 2;
		long left = query(ql, qr, no * 2, leftC, mid);
		long right = query(ql, qr, no * 2 + 1, mid + 1, rightC);
		return calc(left, right);
	}

	static long[] tree;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		tree = new long[N * 4 + 1];
		Arrays.fill(tree, 1);
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		init(1, 1, N);
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				update(b, c, 1, 1, N);
			} else if (a == 2) {
				sb.append(query(b, c, 1, 1, N)).append("\n");
			}

		}
		System.out.println(sb);

	}

}

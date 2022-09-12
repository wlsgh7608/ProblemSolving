import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] minTrees;
	static int[] maxTrees;
	static int[] arr;

	static int calc(int a, int b, boolean isMax) {
		if (isMax) {
			return a > b ? a : b;
		} else {
			return a < b ? a : b;
		}
	}

	static int init(int[] tree, boolean isMax, int no, int leftC, int rightC) {
		int mid = (leftC+rightC)/2;
		if (leftC == rightC) {
			return tree[no] = arr[leftC];
		}
		int left = init(tree, isMax, no * 2, leftC, mid);
		int right = init(tree, isMax, no * 2 + 1, mid + 1, rightC);
		tree[no] = calc(left, right, isMax);
		return tree[no];
	}

	static int query(int[] tree, boolean isMax, int queryL, int queryR, int no, int leftC, int rightC) {
		int mid = (leftC+rightC)/2;
		if (queryR < leftC || rightC < queryL) {
			if (isMax) {
				return 0;
			} else {
				return Integer.MAX_VALUE;
			}
		}
		if (queryL <= leftC && rightC <= queryR) {
			return tree[no];
		}
		int left = query(tree, isMax, queryL, queryR, no * 2, leftC, mid);
		int right = query(tree, isMax, queryL, queryR, no * 2 + 1, mid + 1, rightC);
		return calc(left, right, isMax);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		minTrees = new int[N * 4];
		maxTrees = new int[N * 4];

		arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		init(minTrees, false, 1, 1, N);
		init(maxTrees, true, 1, 1, N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int min = query(minTrees,false,s,e,1,1,N);
			int max = query(maxTrees,true,s,e,1,1,N);
			sb.append(min+" "+max).append("\n");
		}
		System.out.println(sb);

	}

}

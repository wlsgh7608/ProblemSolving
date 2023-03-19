import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static void dfs(int a, int b, int c) {
		if (visited[a][b]) {
			return;
		}
		visited[a][b] = true;
		if (a == 0) {
			answer.add(c);
		}
		if (c > 0) {
			if (a + c > A) {
				int remain = a + c - A;
				dfs(A, b, remain);
			} else {
				dfs(a + c, b, 0);
			}

			if (b + c > B) {
				int remain = b + c - B;
				dfs(a, B, remain);
			} else {
				dfs(a, b + c, 0);
			}

		}

		if (a > 0) {
			if (b + a > B) {
				int remain = a + b - B;
				dfs(remain, B, c);
			} else {
				dfs(0, a + b, c);
			}
			dfs(0, b, a + c);
		}
		if (b > 0) {
			if (a + b > A) {
				int remain = a + b - A;
				dfs(A, remain, c);
			} else {
				dfs(a + b, 0, c);
			}
		}
		dfs(a, 0, b + c);
	}

	static HashSet<Integer> answer = new HashSet<>();
	static boolean[][] visited;

	static int A;
	static int B;
	static int C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		visited = new boolean[A + 1][B + 1];
		dfs(0, 0, C);
		
		List<Integer> list = new ArrayList<>(answer);
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (int n : list) {
			sb.append(n + " ");
		}
		System.out.println(sb);
	}

}

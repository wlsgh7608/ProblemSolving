import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
	static Stack<Integer> S;
	static List<Integer> ans;
	static int max = 0;

	static void dfs(int depth, int prev, int cur) {

		int newN = prev - cur;
		if (newN >= 0) {
			S.add(newN);
			dfs(depth + 1, cur, newN);
			S.pop();
		} else {
			if (depth > max) {
				List<Integer> list = new ArrayList<>();
				for (int n : S) {
					list.add(n);
				}
				ans = list;
				max = depth;
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			S = new Stack<>();
			S.add(N);
			S.add(i);
			dfs(2, N, i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(ans.size() + "\n");
		for (int n : ans) {
			sb.append(n + " ");
		}
		System.out.println(sb);

	}

}

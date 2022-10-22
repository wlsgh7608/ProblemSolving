import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static boolean[] visited;
	static int result;
	static Stack<Integer> S;

	static void dfs(int v) {

		if (visited[v]) {
			int cnt = 0;
			while (!S.isEmpty()) {
				int cur = S.pop();
				cnt++;
				if (cur == v) {
					result += cnt;
					break;
				}
			}

		} else {
			S.add(v);
			visited[v] = true;
			dfs(arr[v]);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < TC; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			visited = new boolean[n + 1];
			result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < n + 1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i < n + 1; i++) {
				if (!visited[i]) {
					S = new Stack<>();
					dfs(i);
				}
			}
			sb.append(n - result).append("\n");
		}
		System.out.println(sb);

	}
}
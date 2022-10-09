import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Book {
		int a;
		int b;

		public Book(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

	}

	static boolean dfs(int v) {
		int s = b[v].a;
		int e = b[v].b;
		for (int i = s; i <= e; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (space[i] == 0 || dfs(space[i])) {
					space[i] = v;
					return true;
				}

			}
		}
		return false;

	}

	static Book[] b;
	static boolean[] visited;
	static int[] space;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 0; t < TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			b = new Book[M + 1];
			space = new int[N + 1];

			for (int i = 1; i < M+1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				b[i] = new Book(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			int result = 0;
			for (int i = 1; i < M+1; i++) {
				visited = new boolean[N + 1];
				if (dfs(i)) {
					result++;

				}
			}
			System.out.println(result);

		}

	}

}




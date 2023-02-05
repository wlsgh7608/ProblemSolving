import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Integer>[] list = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
			list[B].add(A);
		}
		Queue<Integer> Q = new ArrayDeque<>();
		for (int next : list[1]) {
			Q.add(next);
			visited[next] = true;
		}
		visited[1] = true;

		int cnt = 0;
		int size = Q.size();
		for (int i = 0; i < size; i++) {
			int cur = Q.poll();
			for (int next : list[cur]) {
				if (!visited[next]) {
					Q.add(next);
					visited[next] = true;
				}
			}
		}
		System.out.println(size + Q.size());

	}

}

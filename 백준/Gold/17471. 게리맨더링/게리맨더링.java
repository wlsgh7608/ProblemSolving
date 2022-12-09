import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static void bfs(int v, boolean flag) {
		Queue<Integer> Q = new ArrayDeque<>();
		visited[v] = true;
		Q.add(v);

		while (!Q.isEmpty()) {
			int cur = Q.poll();
			for (int next : adjList[cur]) {
				if (isA[next] == flag && !visited[next]) {
					visited[next] = true;
					Q.add(next);
				}
			}
		}

	}

	static final int DEFAULT_POP = 100_000_000;
	static int minDiff = DEFAULT_POP;

	static void comb(int idx, int a) {
		if (idx == N + 1) {
			if (a == 0 || a == sum)
				return;
			visited = new boolean[N + 1];
			for (int i = 1; i < N + 1; i++) {
				if (isA[i]) {
					bfs(i, true);
					break;
				}
			}
			for (int i = 1; i < N + 1; i++) {
				if (!isA[i]) {
					bfs(i, false);
					break;
				}
			}
			for (int i = 1; i < N + 1; i++) {
				if (!visited[i]) {
					return;
				}
			}
			int b = sum - a;

			minDiff = Math.min(minDiff, Math.abs(a - b));
			return;

		}

		isA[idx] = true;
		comb(idx + 1, a + pop[idx]);
		isA[idx] = false;
		comb(idx + 1, a);

	}

	static boolean[] isA;
	static int N;
	static boolean[] visited;
	static List<Integer>[] adjList;
	static int[] pop;
	static int sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pop = new int[N + 1];
		isA = new boolean[N + 1];
		adjList = new ArrayList[N + 1];
		sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
			sum += pop[i];
		}

		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int iter = Integer.parseInt(st.nextToken());
			for (int j = 0; j < iter; j++) {
				adjList[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		comb(1, 0);
		if(minDiff == DEFAULT_POP) {
			minDiff = -1;
		}
		System.out.println(minDiff);
	}

}

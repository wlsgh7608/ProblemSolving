import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] adjList;
	static int[] spaces;
	static boolean[] isVisited;
	static int cnt = 0;

	static boolean dfs(int vertex) {
		for (int next : adjList[vertex]) {
			if (!isVisited[next]) {

				isVisited[next] = true;

				if (spaces[next] == 0) {
					spaces[next] = vertex;
					return true;
				} else if (dfs(spaces[next])) {
					spaces[next] = vertex;
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		spaces = new int[M + 1];
		adjList = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				adjList[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		

		for (int i = 1; i < N + 1; i++) {
			isVisited = new boolean[M + 1];
			if(dfs(i)) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] adjList;
	static boolean[] isVisited;
	static int[] spaces;

	private static boolean dfs(int i) {

		for (int next : adjList[i]) {
			if (!isVisited[next]) {
				isVisited[next] = true;
				if (spaces[next] == 0 || dfs(spaces[next])) {
					spaces[next] = i;
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
		adjList = new ArrayList[N + 1];
		spaces = new int[M + 1];

		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int ea = Integer.parseInt(st.nextToken());
			for (int j = 0; j < ea; j++) {
				adjList[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		int result = 0;
		for (int i = 1; i < N + 1; i++) {
			isVisited = new boolean[M + 1];
			if (dfs(i)) {
				result++;
			}
		}
		System.out.println(result);

	}

}

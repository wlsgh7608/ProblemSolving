import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static class Node {
		int v;
		int d;

		public Node(int v, int d) {
			super();
			this.v = v;
			this.d = d;
		}

	}
	static boolean[] visited;
	static List<Node>[] adjList;
	
	static int dfs(int v, int e,int dist) {
		visited[v] = true;
		if(v==e) {
			return dist;
		}
		
		for(Node next : adjList[v]) {
			if(!visited[next.v]) {
				int result = dfs(next.v,e,dist+next.d);
				if(result>=0) {
					return result;
				}
			}
		}
		return -1;
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adjList = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList[a].add(new Node(b, c));
			adjList[b].add(new Node(a, c));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			visited = new boolean[N+1];
			int result = dfs(s,e,0);
			sb.append(result).append("\n");
		}
		System.out.println(sb);

	}

}

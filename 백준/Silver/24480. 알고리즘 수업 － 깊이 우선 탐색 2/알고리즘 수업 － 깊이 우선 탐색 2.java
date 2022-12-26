import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static List<Integer>[] adjList;
	static int cnt = 1;
	static int[] cntBox;
	
	static void dfs(int v) {
		cntBox[v] = cnt++;
		visited[v] = true;
		for(int next : adjList[v]) {
			if(!visited[next]) {
				dfs(next);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		adjList = new List[N+1];
		cntBox = new int[N+1];
		
		for(int i = 1; i<N+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adjList[u].add(v);
			adjList[v].add(u);
		}
		for(int i = 1; i<N+1;i++) {
			Collections.sort(adjList[i],(o1,o2)->o2-o1);
		}
		
		dfs(R);
		StringBuilder sb= new StringBuilder();
		for(int i = 1; i<N+1;i++) {
			sb.append(cntBox[i]).append("\n");
		}
		System.out.println(sb);
		
	}

}

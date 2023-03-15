import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		List<Integer>[] adjList = new ArrayList[N+1];
		for(int i = 1 ; i<N+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		for(int i = 1;i<=N;i++) {
			Collections.sort(adjList[i],Collections.reverseOrder());
		}
		Queue<Integer> Q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		Q.add(R);
		visited[R] = true;
		StringBuilder sb = new StringBuilder();
		
		int [] ans = new int[N+1];
		int p = 0;
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			ans[cur]= ++p;
			
			for(int next: adjList[cur]) {
				if(!visited[next]) {
					Q.add(next);
					visited[next] = true;
				}
			}
		}
		
		for(int i = 1;i<=N;i++) {
			sb.append(ans[i]).append("\n");
		}
		System.out.println(sb);
	}

}

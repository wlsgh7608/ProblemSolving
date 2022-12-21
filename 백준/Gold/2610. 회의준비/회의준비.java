import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX_NUM = Integer.MAX_VALUE;
	
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] G = new int[N + 1][N + 1];
		visited = new boolean[N+1];

		for (int[] row : G) {
			Arrays.fill(row, MAX_NUM);
		}
		for(int i =1 ;i <=N;i++) {
			G[i][i] = 0;
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			G[a][b] = 1;
			G[b][a] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(G[i][k]!=MAX_NUM&& G[k][j]!=MAX_NUM) {
						G[i][j] = Math.min(G[i][j], G[i][k]+G[k][j]);
					}

				}
			}
		}
		
		List<Integer> ans = new ArrayList<>();
		for(int i = 1;i<=N;i++) {
			if(!visited[i]) {
				List<Integer> adjList = new ArrayList<>();
				for(int j = 1; j<=N;j++) {
					if(G[i][j]!=MAX_NUM) {
						adjList.add(j);
					}
				}
				int totSum = MAX_NUM;
				int personIdx = -1;
				
				//방문처리
				for(int v: adjList) {
					visited[v] = true;
				}
				
				for(int v : adjList) {
					int curMax  = 0;
					
					for(int next : adjList) {
						curMax= Math.max(curMax, G[v][next]);
					}
					
					if(curMax<totSum) {
						totSum = curMax;
						personIdx = v;
					}
				}
				ans.add(personIdx);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(ans.size()).append("\n");
		Collections.sort(ans);
		for(int v : ans) {
			sb.append(v).append("\n");
		}
		System.out.println(sb);
		
		
		
		
		

	}

}

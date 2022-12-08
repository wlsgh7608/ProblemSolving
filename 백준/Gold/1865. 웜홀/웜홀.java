import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static boolean bellman() {
		Arrays.fill(dist, 100_000_000);
		dist[1] = 0;
		
		for(int v = 1;v<N+1;v++) {
			for(int i = 1;i<N+1;i++) {
				for(int j = 1;j<N+1;j++) {
					if(G[i][j]!=NO_ROUTE && dist[i]!=Integer.MAX_VALUE ) {
						
						if(dist[j] > dist[i]+ G[i][j]) {
							dist[j] = Math.min(dist[j], dist[i]+G[i][j]);

							if(v== N) {
								return true;
							}
							
						}
					}
				}
			}
		}
		return false;
		
	}
	
	static int[] dist;
	static int[][] G;
	static int N;
	static final int NO_ROUTE = 20000;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc<TC;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			G = new int[N+1][N+1];
			dist = new int[N+1];
			for(int [] row : G) {
				Arrays.fill(row, NO_ROUTE);
			}
			
			for(int i = 0; i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int s  = Integer.parseInt(st.nextToken());
				int e  = Integer.parseInt(st.nextToken());
				int t  = Integer.parseInt(st.nextToken());
				G[s][e] = Math.min(G[s][e],t);				
				G[e][s] = Math.min(G[e][s],t);				
			}// 도로 
			
			for(int i = 0; i<W;i++) {
				st = new StringTokenizer(br.readLine());
				int s  = Integer.parseInt(st.nextToken());
				int e  = Integer.parseInt(st.nextToken());
				int t  = Integer.parseInt(st.nextToken());
				G[s][e] = Math.min(G[s][e],-t);				
			}// 웜홀
			
			boolean result  = bellman();
			if(result) {
				sb.append("YES").append("\n");
			}else {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
		
	}

}

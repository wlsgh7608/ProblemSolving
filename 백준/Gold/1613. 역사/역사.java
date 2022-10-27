import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] G = new int[N+1][N+1];
		for(int[] row : G) {
			Arrays.fill(row, 1000);
		}
		for(int i = 1 ;i<N+1;i++) {
			G[i][i] = 1;
		}
		for(int i = 0; i<K;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			G[a][b] = 1;
		}
		
		
		for(int k = 1; k<N+1;k++) {
			for(int i = 1;i<N+1;i++) {
				for(int j = 1;j<N+1;j++) {
					if(G[i][k]==1000 ||G[k][j]==1000) {
						continue;
					}
					G[i][j] = Math.min(G[i][j], G[i][k]+G[k][j]);
				}
			}
		}
		
		int S = Integer.parseInt(br.readLine());
		for(int i = 0; i<S;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(G[a][b]<1000) {
				sb.append(-1).append("\n");
			}else if(G[b][a]<1000) {
				sb.append(1).append("\n");
			}else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
		
		
		
		
		
		
	}
}

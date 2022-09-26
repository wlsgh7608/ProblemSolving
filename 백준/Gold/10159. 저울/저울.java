import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] G = new int[N+1][N+1];
		for(int[] row: G) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		for(int i = 0; i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a  = Integer.parseInt(st.nextToken());
			int b  = Integer.parseInt(st.nextToken());
			G[a][b] = 1;
		}
		for(int i = 1;i<N+1;i++) {
			G[i][i] = 0 ;
		}
		
		for(int k = 1;k<N+1;k++) {
			for(int i = 1;i<N+1;i++) {
				for(int j = 1; j<N+1;j++) {
					if(G[i][k]!= Integer.MAX_VALUE && G[k][j] !=Integer.MAX_VALUE) {
						G[i][j] = Math.min(G[i][j], G[i][k]+G[k][j]);
					}
				}
			}
		}
		
		for(int i = 1;i<N+1;i++) {
			int result = 0;
			for(int j = 1;j<N+1;j++) {
				if(i==j) continue;
				
				if(G[i][j]==Integer.MAX_VALUE &&G[j][i]==Integer.MAX_VALUE) {
					result++;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[][] G = new char[N+1][M+1];
		for(char[] row :G) {
			Arrays.fill(row, '.');
		}
		
		for(int i = 0; i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			G[x][y] = '#';
		}
		
		boolean [][] visited = new boolean[N+1][M+1];
		int max = 0;
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		for(int i = 0;i<=N;i++) {
			for(int j = 0 ; j<=M;j++) {
				if(G[i][j]=='#' && !visited[i][j]) {
					visited[i][j] = true;
					Queue<Loc> Q  = new ArrayDeque<>();
					Q.add(new Loc(i,j));
					int cnt = 0;
					
					while(!Q.isEmpty()) {
						Loc cur = Q.poll();
						cnt++;
						
						for(int d = 0 ; d<4;d++) {
							int nx  = cur.x+dx[d];
							int ny = cur.y+dy[d];
							
							if(nx<1 || ny<1 || nx>N|| ny>M || G[nx][ny]=='.' ||visited[nx][ny]) {
								continue;
							}
							
							visited[nx][ny]= true;
							Q.add(new Loc(nx,ny));
						}
						
					}
					max = Math.max(max, cnt);
				}
			}
		}
		System.out.println(max);
	}
	static class Loc{
		int x;
		int y;
		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}

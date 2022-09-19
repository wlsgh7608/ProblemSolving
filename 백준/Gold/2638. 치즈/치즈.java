import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [] dx = {-1,1,0,0};
		int [] dy = {0,0,-1,1};
		
		int[][] map = new int[N][M];
		int time = 0;
		
		
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		while (true) {
			Queue<int[]> Q = new ArrayDeque<>();
			boolean isEnd = true;
			boolean[][] visited = new boolean[N][M];
			List<int[]> cheese = new ArrayList<>();
			for(int i = 0; i<N;i++) {
				for(int j = 0; j<M;j++) {
					if(map[i][j] == 1) {
						isEnd = false;
						cheese.add(new int[] {i,j});
					}
				}
			}
			if(isEnd) {
				break;
			}
			Q.add(new int[] {0,0});
			
			
			while(!Q.isEmpty()) {
				int[] cur = Q.poll();
				int x= cur[0];
				int y = cur[1];
				
				for(int i = 0;i<4;i++) {
					int nx  = x+dx[i];
					int ny = y+dy[i];
					if(nx<0 || nx>=N || ny<0||ny>=M ||visited[nx][ny])
						continue;
					if(map[nx][ny]==0) {
						visited[nx][ny]= true;
						Q.add(new int[] {nx,ny});
					}
				}
			}

			
			for(int[] c : cheese) {
				int x = c[0];
				int y = c[1];
				int cnt = 0;
				for(int i = 0;i<4;i++) {
					int nx= x+dx[i];
					int ny = y+dy[i];
					
					if(nx<0 || nx>=N || ny<0||ny>=M)
						continue;
					if(visited[nx][ny]) {
						cnt++;
					}
				}
				if(cnt>=2) {
					map[x][y] = 0;
				}
			}
			
			time++;

		} // end while
		System.out.println(time);
		
	}

}

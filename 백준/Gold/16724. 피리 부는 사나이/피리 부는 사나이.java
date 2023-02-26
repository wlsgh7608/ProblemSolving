import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static char[][] G;
	static boolean[][] visited;
	static boolean[][] finished;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int fx;
	static int fy;
	static int N;
	static int M;
	static int cnt =0 ;

	static void dfs(int x, int y) {
		visited[x][y] = true;
		fx = x;
		fy = y;
		int nx = x;
		int ny = y;
		switch (G[x][y]) {
		case 'L':
			ny = y - 1;
			break;
		case 'R':
			ny = y + 1;
			break;
		case 'U':
			nx = x - 1;
			break;
		case 'D':
			nx = x + 1;
			break;
		}
		if (nx < 0 || ny < 0 || nx >= N || ny >= M )
			return;
		else if(!visited[nx][ny]) {
			dfs(nx,ny);
		}else if(!finished[nx][ny]) {
			cnt++;
		}
		finished[x][y] = true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = new char[N][M];
		visited = new boolean[N][M];
		finished = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			G[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
				}
				
			}
		}
		System.out.println(cnt);

	}

}

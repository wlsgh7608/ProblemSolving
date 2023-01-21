import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Loc implements Comparable<Loc> {
		int x;
		int y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Loc o) {
			if (this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] G = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[][] dp = new long[N][N];
		dp[0][0] = 1;
		
		PriorityQueue<Loc> Q = new PriorityQueue<>();
		Q.add(new Loc(0,0));
		boolean[][] visited = new boolean[N][N];
		
		visited[0][0]= true;
		
		while(!Q.isEmpty()) {
			Loc cur = Q.poll();
			int x = cur.x;
			int y = cur.y;
			int jump = G[x][y];
			if(jump==0) {
				continue;
			}
			if (x + jump < N) {
				dp[x + jump][y] += dp[x][y];
				if(!visited[x+jump][y]) {
					visited[x+jump][y] = true;
					Q.add(new Loc(x+jump,y));
				}
			}
			if (y + jump < N) {
				dp[x][y + jump] += dp[x][y];
				if(!visited[x][y+jump]) {
					visited[x][y+jump] = true;
					Q.add(new Loc(x,y+jump));
				}
			}
			
			
		}

		System.out.println(dp[N-1][N-1]);

	}
}



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;



public class Main {
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
	}

	static void comb(int depth,int start,int s,int y) {
		if(y>=4) {
			return;
		}
		if(depth == 7) {
			if(y==7) {
				return;
			}
			boolean[] visited = new boolean[7];
			visited[0] = true;
			Queue<Point> Q = new ArrayDeque<>();
			int cnt = 1;
			Q.add(princess[0]);
			while(!Q.isEmpty()) {
				Point cur = Q.poll();
				for(int i = 0; i<7;i++) {
					if(!visited[i]) {
						for(int d = 0;d<4;d++) {
							int nx = cur.x+dx[d];
							int ny = cur.y+dy[d];
							if(nx<0 || ny<0 || nx>=5||ny>=5) {
								continue;
							}
							if(nx==princess[i].x && ny == princess[i].y) {
								visited[i] = true;
								Q.add(princess[i]);
								cnt++;
							}
						}
					}
				}
			}
			if(cnt==7) {
				result++;
			}
			return;
		}
		
		
		
		for(int i = start;i<loc.length;i++) {
			princess[depth] = loc[i];
			int curX = loc[i].x;
			int curY = loc[i].y;
			if(map[curX][curY]=='Y') {
				comb(depth+1,i+1,s,y+1);
			}else {
				comb(depth+1,i+1,s+1,y);
			}
			
		}
		
		
	}

	
	static char[][] map;
	static int N = 5;
	static Point[] princess;
	static Point[] loc;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map =  new char[N][N];
		loc = new Point[25];
		princess = new Point[7];
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<N;j++) {
				loc[i*5+j] = new Point(i,j);
			}
		}
		for(int i = 0; i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		comb(0,0,0,0);
		
		System.out.println(result);
	}

}

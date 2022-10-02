import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int N;
	static int M;
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		StringBuilder sb= new StringBuilder();
		HashMap<Integer, Integer> countMap = new HashMap<>();
		countMap.put(0, 0);
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j<M;j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}
		boolean[][] visited = new boolean[N][M];
		int[][] blankNum = new int[N][M];
		int count = 0;
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(!visited[i][j]&& map[i][j]==0) {
					count++;
					Queue<int[]> que = new ArrayDeque<>();
					visited[i][j] = true;
					que.add(new int[] {i,j});
					int cnt = 0;
					while(!que.isEmpty()) {
						int[] cur = que.poll();
						blankNum[cur[0]][cur[1]] = count;
						cnt++;
						for(int d =0 ;d<4;d++) {
							int nx = cur[0]+dx[d];
							int ny = cur[1]+dy[d];
							
							if(nx<0 ||nx>=N||ny<0||ny>=M||visited[nx][ny]||map[nx][ny]==1) {
								continue;
							}
							visited[nx][ny] = true;
							que.add(new int[] {nx,ny});
						}
						
					}
					countMap.put(count,cnt);
				}
			}
		}
		
		for(int i = 0;i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(map[i][j] ==1) {
					HashSet<Integer> rooms = new HashSet<>();
					int sum =0;
					for(int d =0 ;d<4;d++) {
						int nx = i+dx[d];
						int ny = j+dy[d];
						
						if(nx<0 ||nx>=N||ny<0||ny>=M) {
							continue;
						}
						
						rooms.add(blankNum[nx][ny]);
					}
					for(int n :rooms) {
						sum+=countMap.get(n);
					}
					sb.append((1+sum)%10);
				}else {
					sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
		
		

	}

}

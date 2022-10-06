import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Conv{
		int x;
		int y;
		public Conv(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Conv [x=" + x + ", y=" + y + "]";
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t<TC;t++) {
			int n = Integer.parseInt(br.readLine());
			Conv[] conv = new Conv[n+2];
			for(int i = 0; i<n+2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				conv[i] = new Conv(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			boolean [] visited = new boolean[n+2];
			Queue<Integer> Q = new ArrayDeque<>();
			Q.add(0);
			visited[0] = true;
			String result = "sad";
			
			
			while(!Q.isEmpty()) {
				int v = Q.poll();
				if(v==n+1) {
					result = "happy";
				}
				int x = conv[v].x;
				int y = conv[v].y;
				
				for(int i = 0;i<n+2;i++) {
					if(visited[i]) {
						continue;
					}
					Conv next = conv[i];
					if(Math.abs(x-next.x)+Math.abs(y-next.y) <=1000) {
						Q.add(i);
						visited[i] = true;
					}
				}
				
			}
			sb.append(result).append("\n");
			
		}
		System.out.println(sb);
	}

}

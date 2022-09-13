import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Dog implements Comparable<Dog>{
		
		int v;
		int w;
		public Dog(int v,int w) {
			super();
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Dog o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken())+1;
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		Dog[] dogO = new Dog[N];
		dogO[0] = new Dog(-1,-1);
		int[] dog = new int [N];
		for(int i = 1; i<N;i++) {
			dog[i] = Integer.parseInt(st.nextToken());
			dogO[i] = new Dog(i,dog[i]);
		}
		int[][] dist = new int[N][N];
		int[][]dogTime = new int[N][N];
		for(int[] row:dist) {
			Arrays.fill(row, 100_000_000);
		}
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int maxdog = Math.max(dog[s], dog[e]);
			dist[s][e] = w+maxdog;
			dist[e][s] = w+maxdog;
			dogTime[s][e] = maxdog;
			dogTime[e][s] = maxdog;
		}
		for(int i= 1;i<N;i++) {
			for(int j = 1;j<N;j++) {
				int curMax = Math.max(dog[i], dog[j]);
				dogTime[i][j]= Math.max(dogTime[i][j],curMax);
			}
		}
		
		for(int i = 1;i<N;i++) {
			dist[i][i] = dog[i];
		}
		
		Arrays.sort(dogO);
		
		
		for(int k =1;k<N;k++) {
			int p = dogO[k].v;
			for(int i=1;i<N;i++) {
				for(int j =1;j<N;j++) {
					if(i==p || p==j||i==j)continue;
					if (dist[i][j]> dist[i][p]+dist[p][j]-Math.min(dogTime[i][p], dogTime[p][j])) {
						dist[i][j] = dist[i][p]+dist[p][j]-Math.min(dogTime[i][p], dogTime[p][j]);
						dogTime[i][j] = Math.max(dogTime[i][p],dogTime[p][j]);
					}
				}
			}
		}
		for(int i = 0;i<Q;i++){
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(dist[s][e]!=100_000_000) {
				sb.append(dist[s][e]).append("\n");
			}
			else {
				sb.append(-1).append("\n");
			}
			
		}
		
		System.out.println(sb);
	}

}

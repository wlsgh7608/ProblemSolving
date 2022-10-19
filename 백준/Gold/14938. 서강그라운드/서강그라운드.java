import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[] items = new int[N + 1];
		int[][] dist = new int[N + 1][N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < N+1; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		for (int[] row : dist) {
			Arrays.fill(row, 100);
		}
		for(int i =1;i<N+1;i++) {
			dist[i][i] = 0;
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			dist[s][e] = d;
			dist[e][s] = d;

		}
		
		for(int k = 1; k<N+1;k++) {
			for(int i = 1;i<N+1;i++) {
				for(int j = 1;j<N+1;j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		int maxItem = 0;
		
		for(int i  = 1;i<N+1;i++) {
			int cur = 0;
			for(int j = 1;j<N+1;j++) {
				if(dist[i][j]<=M) {
					cur+=items[j];
				}
			}
			maxItem = Math.max(maxItem, cur);
		}
		System.out.println(maxItem);
		
		

	}

}

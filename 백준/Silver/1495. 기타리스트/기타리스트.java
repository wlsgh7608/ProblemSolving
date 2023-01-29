import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static  void dfs(int idx , int tune) {
		if(idx == N) {
			max_tune = Math.max(max_tune, tune);
			return;
		}
		int minus = tune-arr[idx];
		int plus = tune+arr[idx];

		
		if(minus>=0 && !visited[idx][minus]) {
			visited[idx][minus] = true;
			dfs(idx+1,minus);
		}
		if(plus<=M && !visited[idx][plus]) {
			visited[idx][plus] = true;
			dfs(idx+1,plus);
		}
		
		
		
	}
	
	static int N;
	static int M;
	static int[] arr;
	static boolean[][] visited;
	static int max_tune = -1;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N][M+1];
		
		st  = new StringTokenizer(br.readLine());
		
		for(int i = 0 ;i<N;i++) {
			arr[i]  = Integer.parseInt(st.nextToken());
		}
		dfs(0,S);
		
		System.out.println(max_tune);
		
		
		
	}

}

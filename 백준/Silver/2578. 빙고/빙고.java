import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static void check(int n) {
		for(int i = 0; i<5;i++) {
			for(int j = 0; j<5;j++) {
				if(G[i][j] == n) {
					visited[i][j] = true;
				}
			}
		}
		
	}
	static void getCount() {
		cnt = 0;
		for(int i = 0; i<5;i++) {
			boolean isCheck = true;
			for(int j = 0; j<5;j++) {
				if(!visited[i][j]) {
					isCheck = false;
					break;
				}
			}
			if(isCheck) {
				cnt++;
			}
			isCheck = true;
			for(int j = 0; j<5;j++) {
				if(!visited[j][i] ) {
					isCheck = false;
					break;
				}
			}
			if(isCheck) {
				cnt++;
			}
		}
		
		boolean biCheck = true;
		for(int i = 0;i <5;i++) {
			if(!visited[i][i]) {
				biCheck = false;
				break;
			}
		}
		if(biCheck) {
			cnt++;
		}
		biCheck = true;
		for(int i = 0; i<5;i++) {
			if(!visited[4-i][i]) {
				biCheck = false;
				break;
			}
		}
		if(biCheck) {
			cnt++;
		}
		
	}
	
	
	static int[][] G;
	static int cnt;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = new int[5][5];
		visited = new boolean[5][5];
		
		for(int i = 0; i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0;j<5;j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean isTrue = false;
		int p = 0;
		for(int i = 0; i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5;j++) {
				p++;
				int n = Integer.parseInt(st.nextToken());
				check(n);
				getCount();
				if(cnt>=3) {
					System.out.println(p);
					return;
				}
			}
		}
	}

}

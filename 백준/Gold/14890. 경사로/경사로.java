import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int L;
	static int[][] G;

	public static boolean check(int x, int y, boolean isRow) {

		int[] h = new int[N];
		if (isRow) {
			for (int i = 0; i < N; i++) {
				h[i] = G[x][i];
			}
		}else {
			for(int i = 0; i<N;i++) {
				h[i] = G[i][y];
			}
		}
		
		
		int p = 1;
		int same_cnt = 1;
		while(p<N) {
			int diff = h[p] -h[p-1];
			if(diff>=2 || diff <= -2) {
				return false;
			}else if (diff == 1) {
				if(same_cnt<L) {
					return false;
				}else {
					same_cnt = 1;
				}
				
			}else if (diff == -1) {
				for(int i = 0; i<L-1;i++) {
					p++;
					if(p>=N || h[p] !=h[p-1]) {
						return false;
					}
				}
				same_cnt= 0;
				
			}else if(diff==0) {
				same_cnt++;
			}
			p++;
			
		}
		return true;
		

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		G = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;

		for (int i = 0; i < N; i++) {
			if(check(i,0,true)) {
				result++;
			}
			if (check(0,i,false)){
				result++;
			}
		}

		System.out.println(result);

	}

}

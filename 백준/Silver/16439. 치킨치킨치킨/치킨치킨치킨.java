import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] flavor;
	static int[] sel;
	
	static int max = 0;
	static void comb(int depth, int start) {
		if(depth==3) {
			int sum = 0;
			for(int i = 0; i<N;i++) {
				int cur = 0;
				for(int j : sel) {
					cur = Math.max(cur,flavor[i][j]);
				}
				sum+=cur;
			}
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = start;i<M;i++) {
			sel[depth] = i;
			comb(depth+1,i+1);
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel= new int[3];
		flavor = new int[N][M];
		for(int i= 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				flavor[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0,0);
		System.out.println(max);
		
	}
}

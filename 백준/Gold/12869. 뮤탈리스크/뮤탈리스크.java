import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int perm(int a , int b , int c , int cnt) {
		if(a<=0 && b<=0&& c<=0) {
			minV = Math.min(cnt, minV);
			return cnt;
		}
		a = Math.max(a, 0);
		b = Math.max(b, 0);
		c = Math.max(c, 0);
		if(dp[a][b][c]>0) {
			return dp[a][b][c];
		}
		
		int result = Integer.MAX_VALUE;
		
		if(a>0) {
			result = Math.min(result,perm(a-9,b-3,c-1,cnt+1));
			result = Math.min(result, perm(a-9,b-1,c-3,cnt+1));
		}
		if(b>0) {
			result = Math.min(result,perm(a-1,b-9,c-3,cnt+1));
			result = Math.min(result,perm(a-3,b-9,c-1,cnt+1));
		}
		if(c>0) {
			result = Math.min(result,perm(a-1,b-3,c-9,cnt+1));
			result = Math.min(result,perm(a-3,b-1,c-9,cnt+1));
		}
		return dp[a][b][c] = result;
	}
	static int minV = Integer.MAX_VALUE;
	static int[][][] dp = new int[61][61][61];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0 ; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		switch(arr.length) {
		case 1:
			perm(arr[0],0,0,0);
			break;
		case 2:
			perm(arr[0],arr[1],0,0);
			break;
		case 3:
			perm(arr[0],arr[1],arr[2],0);
			break;
		}
		System.out.println(minV);

	}

}

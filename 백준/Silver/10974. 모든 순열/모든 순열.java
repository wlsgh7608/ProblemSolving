import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] arr ;
	static int[] ans;
	static int[] p;
	static int N;
	static StringBuilder sb= new StringBuilder();
	static void perm(int depth,int flag) {
		if(depth== N) {
			for(int n:ans) {
				sb.append(n+" ");
			}
			sb.append("\n");
			
			
			return;
		}
		for(int i =0;i<N;i++) {
			if((flag & 1<<i) ==0) {
				ans[depth] = arr[i];
				perm(depth+1,flag|1<<i);
			}
		
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		ans = new int[N];
		for(int i = 1;i<N+1;i++) {
			arr[i-1] = i;
		}
		perm(0,0);
		System.out.println(sb);
		
	}

}

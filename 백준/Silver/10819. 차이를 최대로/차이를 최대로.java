import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] pArr;
	static int N;
	static int max= 0;
	static void perm(int depth,int flag) {
		if(depth==N) {
			int result= 0;
			for(int i = 1;i<N;i++) {
				result+=Math.abs(pArr[i-1]-pArr[i]);
			}
			max = Math.max(result, max);
			return;
		}
		for(int i = 0; i<N;i++) {
			if((flag&1<<i)==0) {
				pArr[depth] = arr[i];
				perm(depth+1,flag|1<<i);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		pArr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		perm(0,0);
		System.out.println(max);
		
		
		
	}

}

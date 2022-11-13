import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static HashSet<String> ans = new HashSet<>();
	static int[] arr;
	static int[] pArr;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	
	static void perm(int depth,int flag) {
		if(depth==M) {
			String val ="";
			for(int n : pArr) {
				val+=n+" ";
			}
			if(! ans.contains(val)) {
				sb.append(val).append("\n");
				ans.add(val);
			}
			
			
			
			return;
		}
		
		for(int i = 0 ;i<N;i++) {
			if((flag&1<<i)==0) {
				pArr[depth] =  arr[i];
				perm(depth+1,flag|1<<i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		pArr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(0,0);
		System.out.println(sb);
		
	}

}

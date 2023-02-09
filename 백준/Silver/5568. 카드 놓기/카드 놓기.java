import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	static int N;
	static int K;
	static int[] arr;
	static int[] selected;
	static HashSet<String> hs = new HashSet<>();
	
	static void dfs(int depth,int flag,String str) {
		
		if(depth==K) {
			hs.add(str);
			return;
		}
		
		for(int i = 0; i<N;i++) {
			if((flag&1<<i) == 0) {
				String result = str;
				result+=arr[i];
				dfs(depth+1,flag| 1<<i,result);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		arr = new int[N];
		selected = new int[N];
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dfs(0,0,"");
		System.out.println(hs.size());
	}

}

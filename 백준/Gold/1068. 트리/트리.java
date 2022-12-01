import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer>[] childList;
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		childList = new List[N];
		for(int i = 0; i<N;i++) {
			childList[i] = new ArrayList<>();
		}
		int root = -1;
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]!=-1) {
				int parent = arr[i];
				childList[parent].add(i);
			}else {
				root = i;
			}
		}
		int remove = Integer.parseInt(br.readLine());
		dfs(root,remove);
		System.out.println(result);
		
	}
	
	static void dfs(int v,int remove) {
		if(v==remove) {
			return;
		}
		int cnt = 0;
		for(int n : childList[v]) {
			if(n!=remove) {
				cnt++;
				dfs(n,remove);
			}
		}
		if(cnt==0) {
			result++;
		}
	}

}

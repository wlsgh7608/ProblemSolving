import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	static int N;
	static int[] arr;
	static boolean[] visited;
	static List<Integer> l;
	static void dfs(int v,int end) {
		if(arr[v]==end) {
			l.add(end);
			return;
			
		}
		
		int next = arr[v];
		if(!visited[next]) {
			visited[next] = true;
			dfs(next,end);
			visited[next] = false;
			
		}
		
		
		
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		visited = new boolean[N+1];
		for(int i= 1;i<N+1;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		l = new ArrayList<>();
		for(int i = 1;i<N+1;i++) {
			visited[i] = true;
			dfs(i,i);
			visited[i] = false;
		}
		
		System.out.println(l.size());
		Collections.sort(l);
		for(int n: l) {
			System.out.println(n);
		}
		
		
		
		
	}

}

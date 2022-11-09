import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer >n_list  ;
	static int min_idx(int n) {
		int lo = 0;
		int hi =n_list.size()-1 ;
		while(lo<=hi) {
			int m = (lo+hi)/2;
			if(n_list.get(m)>=n) {
				hi = m-1;
			}else {
				lo = m+1;
			}
		}
		return lo;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	    String input = null;
		while((input = br.readLine()) != null) {
	        int N = Integer.parseInt(input.trim());
			n_list = new ArrayList<>();
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int n : arr) {
				int idx = min_idx(n);
				if(idx==n_list.size()) {
					n_list.add(n);
				}else {
					n_list.set(idx, n);
				}
			}
			sb.append(n_list.size()).append("\n");
		}
		System.out.println(sb);
		
	}

}

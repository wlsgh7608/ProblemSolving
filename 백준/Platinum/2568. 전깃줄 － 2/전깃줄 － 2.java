import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> lis = new ArrayList<>();
	static int getIdx(int n) {
		int lo = 0;
		int hi = lis.size()-1;
		while(lo<=hi) {
			int m = (lo+hi)/2;
			if(lis.get(m)<n) {
				lo = m+1;
			}else {
				hi = m-1;
			}
		}
		return lo;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer,Integer> B = new HashMap<>();
		HashMap<Integer,Integer> pair = new HashMap<>();
		int[] cntBox = new int[N];
		
		for(int i = 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			B.put(a,b);
		}
		List<Integer> a_list = new ArrayList<>(B.keySet());
		Collections.sort(a_list);
		
		for(int a : a_list) {
			int value = B.get(a);
			int idx = getIdx(value);
			if(idx==lis.size()) {
				lis.add(value);
			}else {
				lis.set(idx, value);
			}
			pair.put(a, idx);
		}
		
		
		// A의 카운트 체크하기
		int size = lis.size()-1;
		Stack<Integer> ans = new Stack<>();
		a_list.sort((o1,o2)->o2-o1);
		for(int a : a_list) {
			int cnt = pair.get(a);
			if(cnt==size) {
				size--;
			}else {
				ans.add(a);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(N-lis.size()).append("\n");
		while(!ans.isEmpty()) {
			sb.append(ans.pop()).append("\n");
		}
		System.out.println(sb);
		
	}

}

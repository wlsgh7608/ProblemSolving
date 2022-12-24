import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static class Pair{
		int cnt;
		int num;
		public Pair(int cnt, int num) {
			super();
			this.cnt = cnt;
			this.num = num;
		}
		
	}
	

	static List<Integer> lis = new ArrayList<>();
	
	static int getIdx(int  v) {
		
		int lo = 0;
		int hi = lis.size()-1;
		while(lo<=hi) {
			int m = (lo+hi)/2;
			if(lis.get(m)<v) {
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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] lamp = new int[N]; // 마지막 위치를 기준으로
		Pair[] pair = new Pair[N];
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i = 0; i<N;i++) {	
			int start = Integer.parseInt(st.nextToken());
			hm.put(start,i);
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) {
			int end =Integer.parseInt(st.nextToken());
			int loc = hm.get(end);
			lamp[i] = loc;
			
			int idx = getIdx(lamp[i]);
			if(idx==lis.size()) {
				lis.add(lamp[i]);
			}else {
				lis.set(idx, lamp[i]);
			}
			pair[i] = new Pair(idx,end);
		}
		
		
		
		int cnt = lis.size()-1;
		
		List<Integer> ans = new ArrayList<>();
		for(int i = N-1;i>=0;i--) {
			if(pair[i].cnt == cnt) {
				ans.add(pair[i].num);
				cnt--;
			}
		}
		StringBuilder sb = new StringBuilder();
		Collections.sort(ans);
		sb.append(lis.size()).append("\n");
		for(int n : ans) {
			sb.append(n+" ");
		}
		System.out.println(sb);
		
		
			
		
	}
	

}



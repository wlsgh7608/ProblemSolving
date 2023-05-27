import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i =0  ; i<K;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		HashSet<Integer> hs = new HashSet<>();
		int cnt = 0;
		for(int i = 0; i<K;i++) {
			int cur = arr[i];
			
			if(hs.contains(cur)) {
				continue;
			}
			
			if(hs.size()<N) {
				hs.add(cur);
			}else {
				HashMap<Integer,Integer> firstIdx = new HashMap<>();
				int rNum=0;
				int rValue = 0;
				
				for(int j = i+1;j<K;j++) {					
					int next = arr[j];
					if(firstIdx.containsKey(next)) {
						continue;
					}else{
						firstIdx.put(next, j);
					}
				}
				for(int checkNum : hs) {
					if(!firstIdx.containsKey(checkNum)) {
						rNum = checkNum;
						break;
					}

					if(rValue <firstIdx.get(checkNum)) {
						rNum = checkNum;
						rValue = firstIdx.get(checkNum);
					}
				}
				hs.remove(rNum);
				hs.add(cur);
				cnt++;
				
			}

			
		}
		System.out.println(cnt);
		
		
	}

}

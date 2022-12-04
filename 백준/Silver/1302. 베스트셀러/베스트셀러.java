import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[N];
		List<String> list = new ArrayList<>();
		HashMap<String,Integer> hm = new HashMap<>();
		
		for(int i = 0; i<N;i++) {
			String key = br.readLine();
			if(! hm.containsKey(key)) {
				hm.put(key, 1);
			}else {
				hm.put(key, hm.get(key)+1);
			}
			
		}
		List<String> l = new ArrayList<>();
		for(String s : hm.keySet()) {
			l.add(s);
		}
		Collections.sort(l);
		int max = 0;
		String result ="";
		for(String s : l) {
			if(hm.get(s)>max) {
				max = hm.get(s);
				result = s;
			}
		}
		System.out.println(result);
	}

}

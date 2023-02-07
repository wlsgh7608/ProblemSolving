import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> expand = new HashSet<>();
		HashMap<String,Integer> hm = new HashMap<>();
		for(int i = 0; i<N;i++) {
			String file = br.readLine();
			StringTokenizer st = new StringTokenizer(file,".");
			st.nextToken();
			String exp = st.nextToken();
			hm.put(exp, hm.getOrDefault(exp, 0)+1);
		}
		
		List<String> list = new ArrayList<>(hm.keySet());
		Collections.sort(list);
		
		
		StringBuilder sb = new StringBuilder();
		for(String exp : list) {
			sb.append(exp+ " "+hm.get(exp)).append("\n");
		}
		System.out.println(sb);
		
		
	}

}

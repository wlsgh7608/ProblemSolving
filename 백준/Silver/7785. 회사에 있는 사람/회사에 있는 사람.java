import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> hs = new HashSet<>();
		for(int i= 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String act = st.nextToken();
			if(act.equals("enter")) {
				hs.add(name);
			}else {
				hs.remove(name);
			}
		}
		
		
		List<String> remain_list = new ArrayList<>();
		for(String name : hs) {
			remain_list.add(name);
		}
		Collections.sort(remain_list);
		
		StringBuilder sb = new StringBuilder();
		for(int i = remain_list.size()-1;i>=0;i--) {
			sb.append(remain_list.get(i)).append("\n");
		}
		System.out.println(sb);
		
	}

}

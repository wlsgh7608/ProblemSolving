import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0 ; t<T;t++) {
			HashMap<String, Integer> hm = new HashMap<>();
			int n  = Integer.parseInt(br.readLine());
			String [] arr = new String[n];
			for(int i = 0; i<n;i++) {
				String num = br.readLine();
				arr[i] = num;
				String cur = "";
				for(int j = 0 ; j<num.length();j++) {
					cur+=num.charAt(j);
					hm.put(cur, hm.getOrDefault(cur, 0)+1);
				}
			}
			
			
			String ans ="YES";
			for(String str : arr) {
				if(hm.get(str)>1) {
					ans = "NO";
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		
		
	}

}

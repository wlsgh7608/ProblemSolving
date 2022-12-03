import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> hm = new HashMap<>();
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			hm.put(st.nextToken(),st.nextToken());
		}
		
		for(int i = 0; i<M;i++) {
			String k = br.readLine();
			sb.append(hm.get(k)).append("\n");
		}
		System.out.println(sb);
		
		
	}

}

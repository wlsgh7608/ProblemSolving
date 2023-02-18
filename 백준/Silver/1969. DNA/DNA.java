import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] dnas = new String[N];
		for(int i = 0; i<N;i++) {
			dnas[i] = br.readLine();
		}
		
		char[] l = new char[4];
		l[0] = 'A';
		l[1] = 'C';
		l[2] = 'G';
		l[3] = 'T';

		String result = "";
		int resultCnt = 0;
		for(int i = 0; i<M;i++) {
			Map<Character, Integer> hm = new HashMap<>();
			for(int j = 0; j<N;j++) {
				hm.put(dnas[j].charAt(i), hm.getOrDefault(dnas[j].charAt(i), 0)+1);
			}
			int cnt = hm.getOrDefault('A',0);
			char cur = 'A';
			for(char n : l) {
				if(hm.getOrDefault(n, 0) > cnt) {
					cnt = hm.get(n);
					cur = n;
				}
			}
			result+=cur;
			resultCnt+= (N-hm.get(cur));
		}
		System.out.println(result);
		System.out.println(resultCnt);
		
	}

}

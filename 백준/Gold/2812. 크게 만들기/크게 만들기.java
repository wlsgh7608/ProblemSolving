import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[] input = br.readLine().toCharArray();
		
		Stack<Integer> S = new Stack<>();
		int cutCnt = 0 ;
		for(char c : input) {
			int n = c-'0';
			if(S.isEmpty()) {
				S.add(n);
			}else {
				while(!S.isEmpty()&& S.peek()<n && cutCnt<K) {
					S.pop();
					cutCnt++;
				}
				S.add(n);
			}
		}
		while(cutCnt<K) {
			S.pop();
			cutCnt++;
		}
		for(int n : S) {
			sb.append(n);
		}
		System.out.println(sb);
		
		
	}

}

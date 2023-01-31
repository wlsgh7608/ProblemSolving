
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		
		int cur  = 0;
		for(int i = 0; i<N;i++) {
			cur*=A;
			cur+=Integer.parseInt(st.nextToken());
		}
		Stack<Integer> S = new Stack<>();
		
		while(cur>0) {
			int remain = cur%B;
			cur = cur/B;
			S.add(remain);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!S.isEmpty()) {
			sb.append(S.pop()+" ");
		}
		System.out.println(sb);
	
	
	}

}

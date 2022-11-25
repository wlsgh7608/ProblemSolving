import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> Q = new ArrayDeque<>();
		for(int i = 1;i <=N;i++) {
			Q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!Q.isEmpty()) {
			int c  = Q.poll();
			sb.append(c+" ");
			if(!Q.isEmpty()) {
				Q.add(Q.poll());
			}
			
		}
		System.out.println(sb);
		
	}

}

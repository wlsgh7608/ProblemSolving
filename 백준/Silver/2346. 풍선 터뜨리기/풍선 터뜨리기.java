import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> Q = new ArrayDeque<>();
		Deque<Integer> curQ = new ArrayDeque<>();

		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			Q.add(i);
		}
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 0; i < N; i++) {
			int popEl = Q.pollFirst();
			int cur= arr[popEl];
			if(!Q.isEmpty()) {
				if (cur > 0) {
					for (int j = 0; j < cur - 1; j++) {
						Q.addLast(Q.pollFirst());
					}
				} else {
					cur = cur * -1;
					for (int j = 0; j < cur; j++) {
						Q.addFirst(Q.pollLast());
					}
				}
				
			}

			sb.append(popEl + " ");

		}
		System.out.println(sb);
	}

}

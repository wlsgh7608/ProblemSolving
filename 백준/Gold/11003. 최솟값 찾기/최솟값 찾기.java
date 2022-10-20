
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		Deque<int[]> Q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			while (!Q.isEmpty() && Q.peekLast()[0] > n) {
				Q.pollLast();
			}
			Q.add(new int[] { n, i });

			if (Q.peekFirst()[1] + L - 1 < i) {
				Q.pollFirst();
			}

			sb.append(Q.peekFirst()[0] + " ");
		}
		System.out.println(sb);

	}

}

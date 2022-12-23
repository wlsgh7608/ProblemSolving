import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> hiPQ = new PriorityQueue<>();
			PriorityQueue<Integer> loPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
			List<Integer> ans = new ArrayList<>();
			StringTokenizer st = null;
			for (int p = 0; p < N; p++) {
				if (p % 10 == 0) {
					st = new StringTokenizer(br.readLine());
				}

				int n = Integer.parseInt(st.nextToken());
				if (hiPQ.isEmpty()) {
					hiPQ.add(n);

				} else if (loPQ.isEmpty()) {
					loPQ.add(n);

				} else {
					int lh = loPQ.peek();
					int rl = hiPQ.peek();
					if (lh > rl) {
						hiPQ.add(loPQ.poll());
						loPQ.add(hiPQ.poll());
					}
					int lsize = loPQ.size();
					int hsize = hiPQ.size();
					if (lsize < hsize) {
						loPQ.add(n);
					} else if (lsize == hsize) {
						loPQ.add(n);
						int maxL = loPQ.poll();
						hiPQ.add(maxL);
					}
				}
				if (p % 2 == 0)
					ans.add(hiPQ.peek());

			}
			sb.append(ans.size()).append("\n");
			for (int i = 0; i < ans.size(); i++) {
				if (i % 10 == 9) {
					sb.append(ans.get(i)).append("\n");
				} else {
					sb.append(ans.get(i) + " ");
				}
			}
			if (ans.size() % 10 != 0) {
				sb.append("\n");

			}
		}

		System.out.println(sb);

	}

}

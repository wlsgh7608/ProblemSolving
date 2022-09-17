import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		ArrayList<ArrayList<Integer>> pre = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			pre.add(new ArrayList<>());
		}

		int[] counts = new int[N + 1];
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			pre.get(a).add(b);
			counts[b]++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 1; i < N + 1; i++) {
			if (counts[i] == 0) {
				pq.add(i);
			}
		}
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			System.out.print(cur + " ");
			for (int next : pre.get(cur)) {
				counts[next]--;
				if (counts[next] == 0) {
					pq.add(next);
				}
			}
		}

	}

}

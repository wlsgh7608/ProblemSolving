import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Vote implements Comparable<Vote> {
		int n;
		int cnt;
		int idx;

		public Vote(int n, int cnt, int idx) {
			super();
			this.n = n;
			this.cnt = cnt;
			this.idx = idx;
		}

		public int compareTo(Vote o) {
			if (this.cnt == o.cnt) {
				return this.idx - o.idx;
			}
			return this.cnt - o.cnt;
		}

		@Override
		public String toString() {
			return "Vote [n=" + n + ", cnt=" + cnt + ", idx=" + idx + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		List<Vote> votes = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			int cur = arr[i];
			boolean isAdd = true;
			for (int j = votes.size() - 1; j >= 0; j--) {
				if (votes.get(j).n == cur) {
					votes.get(j).cnt += 1;
					isAdd = false;
				}
			}
			if (isAdd) {
				if (votes.size() == N) {
					Collections.sort(votes);
					votes.remove(0);
				}
				votes.add(new Vote(cur, 1, i));
			}

		}

		StringBuilder sb = new StringBuilder();
		Collections.sort(votes, (o1, o2) -> o1.n - o2.n);
		for (Vote vote : votes) {
			sb.append(vote.n + " ");
		}
		System.out.println(sb);

	}

}

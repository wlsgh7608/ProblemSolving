import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Change {
		int n;
		int cnt;

		public Change(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int tmp = N;
		int digit = 0;
		while (tmp > 0) {
			tmp = tmp / 10;
			digit++;
		}
		Queue<Change> Q = new ArrayDeque<>();
		Q.add(new Change(N, K));

		boolean[][] visited = new boolean[K + 1][1_000_001];
		int answer = -1;


		while (!Q.isEmpty()) {
			Change cur = Q.poll();
			int n = cur.n;
			int cnt = cur.cnt;

			if (cnt == 0) {
				answer = Math.max(answer, n);
				continue;
			}

			for (int i = 0; i < digit; i++) {
				for (int j = i + 1; j < digit; j++) {
					int newN = n;

					int a = (newN / (int) Math.pow(10, digit - i - 1)) % 10;
					int b = (newN / (int) Math.pow(10, digit - j - 1)) % 10;
					
					if(i==0 && b==0) {
						continue;
					}

					newN -= a * (int) Math.pow(10, digit - i - 1);
					newN -= b * (int) Math.pow(10, digit - j - 1);
					newN += b * (int) Math.pow(10, digit - i - 1);
					newN += a * (int) Math.pow(10, digit - j - 1);

					if (!visited[cnt - 1][newN]) {
						visited[cnt - 1][newN] = true;
						Q.add(new Change(newN, cnt - 1));
					}
				}
			}

		}//end while
		System.out.println(answer);

	}

}

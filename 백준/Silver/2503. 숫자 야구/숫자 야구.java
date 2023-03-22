import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class BaseBall {
		String n;
		int s;
		int b;

		public BaseBall(String n, int s, int b) {
			super();
			this.n = n;
			this.s = s;
			this.b = b;
		}

	}

	static void perm(int depth, int flag) {
		if (depth == 3) {
			boolean isTrue = true;
			for (BaseBall b : balls) {
				int s_cnt = 0;
				int b_cnt = 0;

				String question = b.n;

				for (int i = 0; i < 3; i++) {
					int cur = arr[i];
					for (int j = 0; j < 3; j++) {
						if (cur == question.charAt(j)) {
							if (i == j) {
								s_cnt++;
							} else {
								b_cnt++;
							}
						}
					}
				} // 탐색
				if (s_cnt != b.s || b_cnt != b.b) {
					isTrue = false;
					break;
				}

			}
			if (isTrue) {
				tot++;
			}
			return;
		}

		for (int i = 1; i < 10; i++) {
			if ((flag & 1 << i) == 0) {
				arr[depth] = (char) ('0' + i);
				perm(depth + 1, flag | 1 << i);
			}
		}

	}

	static char[] arr;
	static BaseBall[] balls;
	static int tot;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		balls = new BaseBall[N];
		arr = new char[3];
		tot = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			balls[i] = new BaseBall(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		perm(0, 0);
		System.out.println(tot);
	}

}

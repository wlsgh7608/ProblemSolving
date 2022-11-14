import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] judges = new long[N];
		for (int i = 0; i < N; i++) {
			judges[i] = Long.parseLong(br.readLine());
		}

		long max = 0;
		for (long n : judges) {
			max = Math.max(max, n);
		}

		long lo = 1;
		long hi = max * M;

		while (lo <= hi) {
			long m = (lo + hi) / 2;

			long canJudge = 0;
			for (long n : judges) {
				canJudge += m / n;
			}
			if (canJudge >= M) {
				hi = m - 1;
			} else {
				lo = m + 1;
			}

		}
		System.out.println(lo);

	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean[] isPrime = new boolean[N + 1];
		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j * i <= N; j++) {
				if (!isPrime[j * i]) {
					cnt++;
					isPrime[j * i] = true;
					if (cnt == K) {
						System.out.println(j * i);
						return;
					}
				}
			}
		}
	}
}

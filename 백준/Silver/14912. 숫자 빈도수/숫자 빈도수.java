import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			int cur = i;
			while (cur > 0) {
				int remain = cur % 10;
				if (remain == d) {
					cnt++;
				}
				cur = cur / 10;
			}
		}
		System.out.println(cnt);

	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int cnt = 0;
		int weight = 0;
		if (N > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int book = Integer.parseInt(st.nextToken());
				if (book + weight <= M) {
					weight = book + weight;
				} else {
					weight = book;
					cnt++;
				}

			}
			if (weight > 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}

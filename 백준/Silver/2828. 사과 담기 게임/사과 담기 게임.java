import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		int cur = 1;
		int move = 0;
		for (int i = 0; i < K; i++) {
			int apple = Integer.parseInt(br.readLine());
			if (apple < cur) {
				move += cur - apple;
				cur = apple;
			} else {
				move += Math.max(0, apple - (cur + M - 1));
				cur = cur + Math.max(0, apple - (cur + M - 1));
			}
		}
		System.out.println(move);
	}
}

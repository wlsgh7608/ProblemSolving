import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			char[] row = br.readLine().toCharArray();
			Stack<Character> S = new Stack<>();

			for (char c : row) {

				if (!S.isEmpty() && S.peek() == c) {
					S.pop();
					continue;
				}
				S.add(c);

			}
			if (S.isEmpty()) {
				cnt++;
			}

		}
		System.out.println(cnt);
	}

}

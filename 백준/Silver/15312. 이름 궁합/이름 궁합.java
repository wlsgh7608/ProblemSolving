import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] cnt = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
		String A = br.readLine();
		String B = br.readLine();

		int len = A.length() + B.length();

		int[] ans = new int[len];
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			ans[i * 2] = cnt[c - 'A'];
		}

		for (int i = 0; i < B.length(); i++) {
			char c = B.charAt(i);
			ans[i * 2 + 1] = cnt[c - 'A'];
		}

		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				ans[j] = (ans[j] + ans[j + 1]) % 10;
			}

			if (i == len - 3) {
				break;
			}
		}
		String result = "";
		result += ans[0];
		result += ans[1];
		System.out.println(result);

	}

}

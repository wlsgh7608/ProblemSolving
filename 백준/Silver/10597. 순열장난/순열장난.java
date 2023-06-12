import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static boolean[] isUsed;

	static boolean dfs(int idx, String route) {
		if (idx == len) {
			for (int i = 1; i <= N; i++) {
				if (!isUsed[i]) {
					return false;
				}
			}
			ans = route;
			return true;
		}

		String cur = input.substring(idx, idx + 1);
		int n = Integer.parseInt(cur);
		if (!isUsed[n]) {
			isUsed[n] = true;
			boolean result = dfs(idx + 1, route + " " + cur);
			isUsed[n] = false;
			if (result) {
				return true;
			}

		}

		if (idx < len - 1) {
			cur = input.substring(idx, idx + 2);
			n = Integer.parseInt(cur);
			

			if (!isUsed[n] && n <= 50) {
				isUsed[n] = true;
				boolean result = dfs(idx + 2, route + " " + cur);
				isUsed[n] = false;
				if (result) {
					return true;
				}
			}

		}
		return false;

	}

	static String input;
	static int N;
	static String ans = "";
	static int len;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		len = input.length();

		N = input.length();
		if (len >= 10) {
			N = 9 + (len - 9) / 2;
		}

		isUsed = new boolean[100];
		dfs(0, "");
		ans = ans.substring(1);
		System.out.println(ans);

	}

}

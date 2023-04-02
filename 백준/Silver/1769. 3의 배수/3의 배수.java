import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int cnt = 0;
		while (input.length() > 1) {
			int n = 0;
			cnt++;
			for (int i = 0; i < input.length(); i++) {
				n += input.charAt(i) - '0';
			}
			input = "" + n;
		}
		System.out.println(cnt);
		if (Integer.parseInt(input) % 3 == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String target = "UCPC";
		int p = 0;
		boolean isTrue = false;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == target.charAt(p)) {
				p++;
			}
			if (p == 4) {
				isTrue = true;
				break;
			}
		}

		if (isTrue) {
			System.out.println("I love UCPC");
		} else {
			System.out.println("I hate UCPC");
		}

	}

}

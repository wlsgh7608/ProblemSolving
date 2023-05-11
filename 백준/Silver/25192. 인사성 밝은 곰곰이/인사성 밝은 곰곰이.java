import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashSet<String> hs = new HashSet<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (str.equals("ENTER")) {
				hs = new HashSet<>();
			} else if (hs.contains(str)) {
				continue;
			} else {
				hs.add(str);
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}

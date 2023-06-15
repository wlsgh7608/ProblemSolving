import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashMap<String, Double> scores = new HashMap<>();
		scores.put("A+", 4.5);
		scores.put("A0", 4.0);
		scores.put("B+", 3.5);
		scores.put("B0", 3.0);
		scores.put("C+", 2.5);
		scores.put("C0", 2.0);
		scores.put("D+", 1.5);
		scores.put("D0", 1.0);
		scores.put("F", 0.0);

		double result = 0;
		double cnt = 0;
		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			double c = Double.parseDouble(st.nextToken());
			String score = st.nextToken();

			if (score.equals("P")) {
				continue;
			}

			cnt += c;
			result += c * scores.get(score);
		}
		double ans = result / cnt;
		System.out.printf("%.6f", ans);

	}

}

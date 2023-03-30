import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		boolean[] isVisited = new boolean[1001];
		Arrays.fill(isVisited, false);
		for (int i = 2; i * i <= 1000; i++) {
			for (int j = 2; i * j <= 1000; j++) {
				isVisited[i * j] = true;
			}
		}
		isVisited[0] = true;
		isVisited[1] = true;

		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= 1000; i++) {
			if (!isVisited[i]) {
				list.add(i);
			}
		}
		int size = list.size();
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			boolean isTrue = false;

			int a = 0;
			int b = 0;
			int c = 0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					for (int k = 0; k < size; k++) {
						a = list.get(i);
						b = list.get(j);
						c = list.get(k);
						if (a + b + c == N) {
							isTrue = true;
						}

						if (isTrue) {
							break;
						}
					}
					if (isTrue) {
						break;
					}

				}
				if (isTrue) {
					break;
				}
			} // end for

			if (isTrue) {
				sb.append(a + " " + b + " " + c).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);

	}

}

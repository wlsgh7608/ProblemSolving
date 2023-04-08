import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(br.readLine());

		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();

		rows.add(0);
		rows.add(N);
		cols.add(0);
		cols.add(M);

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if (p == 0) {
				rows.add(n);
			} else {
				cols.add(n);
			}
		}
		Collections.sort(rows);
		Collections.sort(cols);
		int maxSize = 0;

		for (int i = 1; i < rows.size(); i++) {
			int row_diff = rows.get(i) - rows.get(i - 1);

			for (int j = 1; j < cols.size(); j++) {
				int col_diff = cols.get(j) - cols.get(j - 1);

				int size = row_diff * col_diff;
				maxSize = Math.max(maxSize, size);
			}
		}

		System.out.println(maxSize);
	}

}

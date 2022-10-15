import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static void comb(int i, int e, long sum, List<Long> list) {
		if (i == e) {
			list.add(sum);
			return;
		}
		if (sum + bag[i] <= C) {
			comb(i + 1, e, sum + bag[i], list);
		}
		comb(i + 1, e, sum, list);

	}

	static int N;
	static int C;
	static int cnt = 0;
	static int[] bag;
	static List<Long> bag1;
	static List<Long> bag2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		bag = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			bag[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(bag);
		bag1 = new ArrayList<>();
		bag2 = new ArrayList<>();

		comb(0, N / 2, 0, bag1);
		comb(N / 2, N, 0, bag2);
		Collections.sort(bag1);
		Collections.sort(bag2);

		int ans = 0;
		for (int i = 0; i < bag1.size(); i++) {
			int lo = 0;
			int hi = bag2.size() - 1;

			while (lo <= hi) {
				int m = (lo + hi) / 2;
				if (bag1.get(i) + bag2.get(m) <= C) {
					lo = m + 1;
				} else {
					hi = m - 1;
				}
			}
			ans += lo;
		}
		System.out.println(ans);

	}

}

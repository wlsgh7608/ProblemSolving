import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static void getSum(int d, int e, int cnt, int sum, List<Integer> list) {
		if (d == e) {
			list.add(sum);
			return;
		}
		getSum(d + 1, e, cnt + 1, sum + arr[d], list);
		getSum(d + 1, e, cnt, sum, list);

	}

	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		getSum(0, N / 2, 0, 0, list1);
		getSum(N / 2, N, 0, 0, list2);

		Collections.sort(list1);
		Collections.sort(list2);

		long result = 0;
		for (int case1 : list1) {
			int lo = 0;
			int hi = list2.size() - 1;

			while (lo <= hi) {
				int m = (lo + hi) / 2;
				if (case1 + list2.get(m) >= S) {
					hi = m - 1;
				} else {
					lo = m + 1;
				}
			}
			int left = lo;
			lo = 0;
			hi = list2.size() - 1;
			while (lo <= hi) {
				int m = (lo + hi) / 2;
				if (case1 + list2.get(m) > S) {
					hi = m - 1;
				} else {
					lo = m + 1;
				}
			}
			int right = lo;

			result += right - left;
		}
		if(S ==0) {
			result-=1;
		}
		System.out.println(result);

	}

}

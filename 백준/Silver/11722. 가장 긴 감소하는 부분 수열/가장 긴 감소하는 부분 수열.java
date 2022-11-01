import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	static List<Integer> list;

	static int minIdx(int n) {
		int lo = 0;
		int hi = list.size() - 1;
		while (lo <= hi) {
			int m = (lo + hi) / 2;
			if (list.get(m) > n) {
				lo = m + 1;
			} else {
				hi = m - 1;
			}

		}

		return lo;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList<>();

		for (int n : arr) {
			int idx = minIdx(n);
			if(idx==list.size()) {
				list.add(n);
			}else {
				list.set(idx, n);
			}

		}
		System.out.println(list.size());
	}

}

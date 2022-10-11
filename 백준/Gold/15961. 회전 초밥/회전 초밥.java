import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] dish = new int[N + k - 1];

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			dish[i] = n;
		}
		for (int i = 0; i < k - 1; i++) {
			dish[N + i] = dish[i];
		}

		int[] dishCnt = new int[d + 1];

		int result = 0;
		int maxDish = 0;

		for (int i = 0; i < k; i++) {
			int cur = dish[i];
			if (dishCnt[cur] == 0) {
				result += 1;
			}
			dishCnt[cur] += 1;
		}
		maxDish = result;
		for (int i = k; i < N + k - 1; i++) {
			int cur = dish[i];
			if (dishCnt[cur] == 0) {
				result += 1;
			}
			dishCnt[cur] += 1;
			dishCnt[dish[i - k]] -= 1;
			if (dishCnt[dish[i - k]] == 0) {
				result -= 1;
			}
			if (dishCnt[c] == 0) {
				maxDish = Math.max(maxDish, result + 1);
			} else {
				maxDish = Math.max(maxDish, result);
			}


		}
		System.out.println(maxDish);

	}

}

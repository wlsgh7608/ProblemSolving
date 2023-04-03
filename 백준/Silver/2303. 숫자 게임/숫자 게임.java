
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static void comb(int depth, int idx, int sum, int[] arr, int number) {
		if (depth == 3) {
			if (sum % 10 >= N) {
				N = sum % 10;
				ANS = number;
			}
		}
		for (int i = idx; i < 5; i++) {
			comb(depth + 1, i + 1, sum + arr[i], arr, number);
		}

	}

	static int N = 0;
	static int ANS = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int[] arr = new int[5];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			comb(0, 0, 0, arr, i + 1);
		}
		System.out.println(ANS);
	}

}

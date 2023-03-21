import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int N = str.length;
		int[] arr = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			arr[i] = str[i] - '0';
		}

		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i == 0) {
			System.out.println(0);
		} else {
			int j = N - 1;
			while (arr[i - 1] >= arr[j]) {
				j--;
			}

			// swap
			int tmp = arr[i - 1];
			arr[i - 1] = arr[j];
			arr[j] = tmp;

			// sort
			int k = N - 1;
			while (i < k) {
				tmp = arr[i];
				arr[i] = arr[k];
				arr[k] = tmp;
				i++;
				k--;
			}
			StringBuilder sb = new StringBuilder();
			for(int n: arr) {
				sb.append(n);
			}
			System.out.println(sb);

		}

	}

}

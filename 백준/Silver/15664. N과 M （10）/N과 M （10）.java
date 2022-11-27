
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static int[] arr;
	static int[] cArr;
	static HashSet<String> hs = new HashSet<>();
	static StringBuilder sb = new StringBuilder();

	static void comb(int depth, int start) {
		if (depth == M) {
			String s = "";
			for (int c : cArr) {
				s += c + " ";
			}
			if (!hs.contains(s)) {
				hs.add(s);
				sb.append(s).append("\n");
			}

			return;
		}

		for (int i = start; i < N; i++) {
			cArr[depth] = arr[i];
			comb(depth + 1, i + 1);

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		cArr = new int[M];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		comb(0, 0);
		System.out.println(sb);
	}

}

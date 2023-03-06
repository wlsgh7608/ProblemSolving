import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = 0;
		String[] nums = new String[N];
		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < N; i++) {
			nums[i] = br.readLine();
			M = nums[i].length();
			int p = M;
			String cur = "";
			while (p-- > 0) {
				cur = nums[i].charAt(p) + cur;
				hm.put(cur, hm.getOrDefault(cur, 0) + 1);
			}
		}
		int[] ans = new int[N];
		for (int i = 0; i < N; i++) {
			String cur = "";
			for (int j = M - 1; j >= 0; j--) {
				cur = nums[i].charAt(j) + cur;
				int c = hm.get(cur);
				if (c == 1) {
					ans[i] = M - j;
					break;
				}
			}
		}
		int max = 0;
		for (int n : ans) {
			if (n > max) {
				max = n;
			}
		}
		System.out.println(max);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int result = 0;
	static int N;
	static int K;
	static String[] words;

	public static void dfs(int depth, int start, int flag) {
		if (depth == K) {
			int cnt = 0;
			for (String word : words) {
				boolean check = true;
				for (int i = 0; i < word.length(); i++) {
					if ((flag & 1 << (word.charAt(i)-'a')) == 0) {
						check = false;
						break;
					}
				}
				if (check) {
					cnt++;
				}
				result = Math.max(result, cnt);
			}
			return;

		}

		for (int i = start; i < 26; i++) {
			if ((flag & 1 << i) == 0) {
				dfs(depth + 1, i + 1, flag | 1 << i);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
			words[i].replace("a", "");
			words[i].replace("t", "");
			words[i].replace("n", "");
			words[i].replace("i", "");
			words[i].replace("c", "");
		}

		int flag = 0;
		flag = flag | 1 << ('a' - 'a');
		flag = flag | 1 << ('n' - 'a');
		flag = flag | 1 << ('c' - 'a');
		flag = flag | 1 << ('t' - 'a');
		flag = flag | 1 << ('i' - 'a');
		dfs(5, 0, flag);
		System.out.println(result);

	}
}

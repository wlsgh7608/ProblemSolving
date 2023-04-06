import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class NumberCount implements Comparable<NumberCount> {
		int n;
		String ans;

		public NumberCount(int n, String ans) {
			super();
			this.n = n;
			this.ans = ans;
		}

		public int compareTo(NumberCount o) {
			return this.ans.compareTo(o.ans);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(0, "zero");
		hm.put(1, "one");
		hm.put(2, "two");
		hm.put(3, "three");
		hm.put(4, "four");
		hm.put(5, "five");
		hm.put(6, "six");
		hm.put(7, "seven");
		hm.put(8, "eight");
		hm.put(9, "nine");

		int p = N;
		List<NumberCount> list = new ArrayList<>();
		while (p <= M) {
			String newN = "" + p;
			String cur = "";
			int length = newN.length();
			for (int i = 0; i < length; i++) {
				cur += hm.get(newN.charAt(i) - '0');
			}
			list.add(new NumberCount(p, cur));
			p++;
		}
		Collections.sort(list);
		p = 0;
		int size = list.size();
		StringBuilder sb = new StringBuilder();
		while (p < size) {
			sb.append(list.get(p).n).append(" ");
			if (p % 10 == 9) {
				sb.append("\n");
			}
			p++;
		}
		System.out.println(sb);
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();

		Stack<Character> S = new Stack<>();
		boolean isTag = false;
		for (char c : str) {
			if (c == '<') {
				isTag = true;
				while (!S.isEmpty()) {
					sb.append(S.pop());
				}
			}
			if (!isTag && c == ' ') {
				while (!S.isEmpty()) {
					sb.append(S.pop());
				}
				sb.append(" ");
				continue;
			} else {
				S.add(c);
			}
			if (S.peek() == '>') {
				Stack<Character> tag = new Stack<>();
				while (!S.isEmpty()) {
					char cur = S.pop();
					tag.add(cur);
					if (cur == '<')
						break;
				}
				while (!tag.isEmpty()) {
					sb.append(tag.pop());
				}
				isTag = false;
			}
		}
		while (!S.isEmpty()) {
			sb.append(S.pop());
		}
		System.out.println(sb);

	}

}

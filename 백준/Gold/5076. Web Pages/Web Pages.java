import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("#")) {
                break;
            }

            int N = input.length();
            boolean isTag = false;
            String tag = "";
            Stack<String> S = new Stack<>();
            for (int i = 0; i < N; i++) {
                char c = input.charAt(i);
                if (c == '<') {
                    isTag = true;
                    continue;
                } else if (c == '>') {
                    if (tag.charAt(tag.length() - 1) == '/') {
                        tag = "";
                    } else if (!S.isEmpty() && S.peek().equals(tag.substring(1))) {
                        tag = "";
                        S.pop();
                    } else {
                        S.push(tag);
                        tag = "";
                    }
                    isTag = false;
                    continue;
                } else if (c == ' ') {
                    if (i + 1 < N && input.charAt(i + 1) == '/') {
                        isTag = true;
                    } else {
                        isTag = false;
                    }

                }
                if (isTag) {
                    tag += c;
                }
            }


            if (S.isEmpty()) {
                sb.append("legal").append("\n");
            } else {
                sb.append("illegal").append("\n");
            }
        }
        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> S = new Stack<>();

        long cnt = 0;
        char prev = ')';

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ')') {
                // lazer
                S.pop();
                if (prev == '(') {
                    cnt += S.size();
                } else {
                    cnt += 1;
                }
            } else {
                S.add('(');
            }
            prev = c;
        }
        System.out.println(cnt);
    }
}

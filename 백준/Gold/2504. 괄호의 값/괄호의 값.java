import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> S = new Stack<>();
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put(']', '[');
        hm.put(')', '(');
        hm.put('(', '2');
        hm.put('[', '3');
        int result = 0;
        int val = 1;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '[') {
                S.add(c);
                val *= hm.get(c) - '0';
            } else if (c == ']' || c == ')') {
                if (S.isEmpty() || S.peek() != hm.get(c)) {
                    System.out.println(0);
                    return;
                }

                if (input.charAt(i - 1) == hm.get(c)) {
                    result += val;
                }
                char key = S.pop();
                val /= (hm.get(key) - '0');
            }
        }
        if (!S.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }

    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = input.length();
        List<String> result = new ArrayList<>();

        for (int i = 1; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                String A = input.substring(0, i);
                String B = input.substring(i, j);
                String C = input.substring(j, N);

                Stack<Character> stackA = new Stack<>();
                Stack<Character> stackB = new Stack<>();
                Stack<Character> stackC = new Stack<>();
                for (int k = 0; k < A.length(); k++) {
                    stackA.add(A.charAt(k));
                }
                for (int k = 0; k < B.length(); k++) {
                    stackB.add(B.charAt(k));
                }
                for (int k = 0; k < C.length(); k++) {
                    stackC.add(C.charAt(k));
                }


                String ans = "";
                while (!stackA.isEmpty()) {
                    ans += stackA.pop();
                }
                while (!stackB.isEmpty()) {
                    ans += stackB.pop();
                }
                while (!stackC.isEmpty()) {
                    ans += stackC.pop();
                }
                result.add(ans);
            }
        }
        Collections.sort(result);
        System.out.println(result.get(0));


    }
}

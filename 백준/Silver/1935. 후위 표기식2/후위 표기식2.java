import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> hm = new HashMap<>();
        String input = br.readLine();
        Stack<Double> S = new Stack<>();


        for (int i = 0; i < N; i++) {

            char c = (char)('A' + i);
            int n = Integer.parseInt(br.readLine());
            hm.put(c, n);
        }


        for(int i = 0 ;i<input.length();i++){
            char c = input.charAt(i);

            switch (c){
                case '+':
                    double a = S.pop();
                    double b = S.pop();
                    S.add(a + b);
                    break;
                case '-':
                    a = S.pop();
                    b = S.pop();
                    S.add(b - a);
                    break;
                case '*':
                    a = S.pop();
                    b = S.pop();
                    S.add(a * b);
                    break;
                case '/':
                    a = S.pop();
                    b = S.pop();
                    S.add(b/a);
                    break;
                default:
                    int value = hm.get(c);
                    S.add((double)value);

            }
        }
        System.out.printf("%.2f",S.pop());

    }
}

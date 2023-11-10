import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int stackCnt = 0;
        int cnt = 0;
        char prev = ')';

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ')') {
                // lazer
                stackCnt--;
                if (prev == '(') {
                    cnt += stackCnt;
                } else {
                    cnt += 1;
                }
            } else {
                stackCnt++;
            }
            prev = c;
        }
        System.out.println(cnt);
    }
}

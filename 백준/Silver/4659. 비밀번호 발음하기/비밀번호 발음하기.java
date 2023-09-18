import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');

        while (!input.equals("end")) {
            boolean isTrue = false;
            int vCnt = 0;
            int nCnt = 0;

            char prev = 0;
            int N = input.length();
            for (int i = 0; i < N; i++) {
                char cur = input.charAt(i);
                if (hs.contains(cur)) {
                    isTrue = true;
                }

                if (hs.contains(cur)) {
                    vCnt++;
                    nCnt = 0;
                } else {
                    nCnt++;
                    vCnt = 0;
                }

                if (vCnt >= 3 || nCnt >= 3) {
                    isTrue = false;
                    break;
                }
                if (i > 0) {
                    if (prev == cur) {
                        if (cur != 'e' && cur != 'o') {
                            isTrue = false;
                            break;
                        }
                    }
                }
                prev = cur;
            } // end for
            sb.append("<");
            sb.append(input);
            sb.append("> ");
            if (isTrue) {
                sb.append("is acceptable.");
            } else {
                sb.append("is not acceptable.");
            }
            sb.append("\n");
            input = br.readLine();
        } // end while
        System.out.println(sb);
    }
}

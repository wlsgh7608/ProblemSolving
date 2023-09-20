import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int oddCnt = 0;

        int N = input.length();


        final String WRONG = "I'm Sorry Hansoo";

        char[] answer = new char[N];
        int[] cntBox = new int[26];
        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);
            cntBox[c - 'A']++;
        }
        char oddChar = ' ';

        for (int i = 0; i < 26; i++) {
            if (cntBox[i] % 2 == 1) {
                oddCnt++;
                oddChar = (char) ('A' + i);
            }
        }

        if (oddCnt > 1) {
            System.out.println(WRONG);
        } else {
            StringBuilder sb = new StringBuilder();
            int p = 0;
            int mid = N / 2;
            for (int i = 0; i < 26; i++) {
                while (cntBox[i] >= 2) {
                    answer[p] = answer[N - 1 - p] = (char) ('A' + i);
                    p++;
                    cntBox[i] -= 2;
                }
            }
            if (oddCnt == 1) {
                answer[mid] = oddChar;
            }
            for (char c : answer) {
                sb.append(c);
            }

            System.out.println(sb);
        }


    }
}

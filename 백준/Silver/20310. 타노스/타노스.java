import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int cnt0 = 0;
        int cnt1 = 0;
        int N = str.length();
        boolean[] isUsed = new boolean[N];
        Arrays.fill(isUsed, true);

        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == '0') {
                cnt0++;
            } else {
                cnt1++;
            }
        }

        int breakCnt0 = 0;
        int breakCnt1 = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (breakCnt0 == cnt0 / 2) {
                break;
            }

            if (str.charAt(i) == '0') {
                isUsed[i] = false;
                breakCnt0++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (breakCnt1 == cnt1 / 2) {
                break;
            }

            if (str.charAt(i) == '1') {
                isUsed[i] = false;
                breakCnt1++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (isUsed[i]) {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb);


    }
}

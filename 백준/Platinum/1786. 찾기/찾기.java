import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[] getPrefix(char[] str) {
        int[] pi = new int[str.length];
        int j = 0;
        for (int i = 1; i < pi.length; i++) {
            while (j > 0 && str[i] != str[j]) {
                j = pi[j - 1];
            }
            if (str[j] == str[i]) {
                j++;
            }
            pi[i] = j;
        }
        return pi;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] T = br.readLine().toCharArray();
        char[] P = br.readLine().toCharArray();
        int[] pi = getPrefix(P);

        int j = 0;
        int cnt = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < T.length; i++) {
            while (j > 0 && P[j] != T[i]) {
                j = pi[j - 1];
            }
            if (T[i] == P[j]) {
                if (j == P.length - 1) {
                    cnt++;
                    result.add(i - P.length + 2);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        System.out.println(cnt);
        for (int n : result) {
            System.out.print(n + " ");
        }

    }
}
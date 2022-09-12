import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[] getPrefix(String str) {
        int[] pi = new int[str.length()];
        int j = 0;
        for (int i = 1; i < pi.length; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }
            if (str.charAt(j) == str.charAt(i)) {
                j++;
            }
            pi[i] = j;
        }
        return pi;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();
        int[] pi = getPrefix(P);

        int j = 0;
        int cnt = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < T.length(); i++) {
            while (j > 0 && P.charAt(j) != T.charAt(i)) {
                j = pi[j - 1];
            }
            if (T.charAt(i) == P.charAt(j)) {
                if (j == P.length() - 1) {
                    cnt++;
                    result.add(i - P.length() + 2);
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
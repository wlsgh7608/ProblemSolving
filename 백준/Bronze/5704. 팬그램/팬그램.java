import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("*")) {
                break;
            }
            boolean[] alphabet = new boolean[26];
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    continue;
                }
                alphabet[str.charAt(i) - 'a'] = true;
            }
            boolean isPangram = true;
            for (int i = 0; i < 26; i++) {
                if (!alphabet[i]) {
                    isPangram = false;
                    break;
                }
            }
            if (isPangram) {
                sb.append("Y\n");
            } else {
                sb.append("N\n");
            }
        }
        System.out.println(sb);
    }
}

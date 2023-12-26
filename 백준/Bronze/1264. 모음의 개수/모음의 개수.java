import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Character> hs = new HashSet<>();
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char vowel : vowels) {
            hs.add(vowel);
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line.equals("#")) {
                break;
            }
            int N = line.length();
            int tmpCnt = 0;

            for (int i = 0; i < N; i++) {
                char c = line.charAt(i);
                if (hs.contains(c)) {
                    tmpCnt++;
                }
            }
            sb.append(tmpCnt).append("\n");
        }
        System.out.println(sb);
    }
}

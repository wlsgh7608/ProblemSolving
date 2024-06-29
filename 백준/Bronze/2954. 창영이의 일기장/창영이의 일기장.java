import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();

        char prev = '.';
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            char c = str.charAt(i);
            if (vowels.contains(c)) {
                if (i + 2 < N) {
                    char next = str.charAt(i + 1);
                    char next2 = str.charAt(i + 2);
                    if (next == 'p' && c == next2) {
                        sb.append(c);
                        i += 2;
                        continue;
                    }
                }
            }
            sb.append(c);
        }
        System.out.println(sb);

    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals("#")) {
                break;
            }
            int cnt = 0;
            HashSet<Character> hs = new HashSet<>();
            str = str.toLowerCase();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if('a'<=c && c<='z'){
                    hs.add(c);
                }
            }
            sb.append(hs.size()).append("\n");
        }
        System.out.println(sb);
    }
}

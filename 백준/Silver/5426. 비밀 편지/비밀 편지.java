import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String words = br.readLine();
            int N = words.length();

            int len = (int) Math.pow(N, 0.5);
            char[][] G = new char[len][len];

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    G[i][j] = words.charAt(i * len + j);
                }
            }
            for (int j = len - 1; j >= 0; j--) {
                for (int i = 0; i < len; i++) {
                    sb.append(G[i][j]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

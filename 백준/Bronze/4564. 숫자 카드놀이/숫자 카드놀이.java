import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int cur = Integer.parseInt(br.readLine());
            if (cur == 0) {
                break;
            }
            while (true) {
                sb.append(cur).append(" ");
                if (cur < 10) {
                    break;
                }
                int result = 1;
                while (cur > 0) {
                    result *= (cur % 10);
                    cur /= 10;
                }
                cur = result;
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}

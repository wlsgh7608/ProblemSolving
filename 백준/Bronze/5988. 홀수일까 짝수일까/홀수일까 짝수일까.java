import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String num = br.readLine();
            int n = num.charAt(num.length() - 1) - '0';
            if (n % 2 == 0) {
                sb.append("even");
            } else {
                sb.append("odd");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}

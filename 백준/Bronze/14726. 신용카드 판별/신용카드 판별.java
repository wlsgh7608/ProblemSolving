import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String str = br.readLine();
            int sum = 0;
            int N = str.length();
            for (int i = 0; i < str.length(); i++) {
                int num = str.charAt(N - i - 1) - '0';
                if (i % 2 == 1) {
                    num *= 2;
                    if (num >= 10) {
                        num = num / 10 + num % 10;
                    }
                }
                sum += num;
            }
            if (sum % 10 == 0) {
                sb.append("T\n");
            } else {
                sb.append("F\n");
            }
        }
        System.out.println(sb);
    }
}

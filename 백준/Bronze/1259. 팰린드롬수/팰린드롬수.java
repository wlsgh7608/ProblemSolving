import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        do {
            String str = br.readLine();
            if (str.equals("0")) {
                break;
            }
            char[] input = str.toCharArray();

            int N = input.length;

            boolean isOk = true;
            int p = 0;
            int q = N - 1;

            while (p <= q) {
                if (input[p] == input[q]) {
                    p++;
                    q--;
                } else {
                    isOk = false;
                    break;
                }
            }
            sb.append(isOk ? "yes" : "no").append("\n");
        } while (true);
        System.out.println(sb);
    }
}

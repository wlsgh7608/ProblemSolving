import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        char op = br.readLine().charAt(0);
        String B = br.readLine();

        int lenA = A.length();
        int lenB = B.length();

        StringBuilder sb = new StringBuilder();
        if (op == '*') {
            sb.append(1);
            for (int i = 0; i < lenA + lenB - 2; i++) {
                sb.append(0);
            }
        } else {
            if (lenA == lenB) {
                sb.append(2);
                for (int i = 0; i < lenA - 1; i++) {
                    sb.append(0);
                }
            } else {
                sb.append(1);
                for (int i = 0; i < Math.abs(lenA-lenB)- 1; i++) {
                    sb.append(0);
                }
                sb.append(1);
                for (int i = 0; i < Math.min(lenA, lenB) - 1; i++) {
                    sb.append(0);
                }
            }

        }
        System.out.println(sb);

    }
}

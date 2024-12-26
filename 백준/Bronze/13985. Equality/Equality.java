import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int a = str.charAt(0) - '0';
        int b = str.charAt(4) - '0';
        int c = str.charAt(8) - '0';

        if (a + b == c) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}

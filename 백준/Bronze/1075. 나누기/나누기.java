import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());

        n = n / 100 * 100;

        for (int i = 0; i < 100; i++, n++) {
            if (n % f == 0) {
                break;
            }
        }

        int remain = n % 100;
        if (remain < 10) {
            System.out.print("0" + remain);
        } else {
            System.out.print(remain);
        }
    }
}
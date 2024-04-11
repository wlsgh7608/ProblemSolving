import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N % 5 == 0) {
            System.out.println(N / 5);
        } else {
            System.out.println(N / 5 + 1);
        }

    }
}

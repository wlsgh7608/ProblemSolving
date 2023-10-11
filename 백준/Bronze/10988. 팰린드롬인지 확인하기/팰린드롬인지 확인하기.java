import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
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
        System.out.println(isOk ? 1 : 0);

    }
}

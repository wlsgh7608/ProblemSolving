import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) % 2;

        String str = "SciComLove";

        if (N == 1) {
            System.out.println(new StringBuilder(str).reverse());
        } else {
            System.out.println(str);
        }

    }
}

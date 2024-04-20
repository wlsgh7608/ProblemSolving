import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxPrice = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int price = getPrice(a, b, c);
            maxPrice = Math.max(maxPrice, price);
        }
        System.out.println(maxPrice);
    }

    private static int getPrice(int a, int b, int c) {
        if (a == b && a == c) {
            return 10000 + a * 1000;
        }

        if (a == b) {
            return 1000 + a * 100;
        }
        if (b == c) {
            return 1000 + b * 100;
        }
        if (a == c) {
            return 1000 + c * 100;
        }
        int max = Math.max(a, Math.max(b, c));
        return max * 100;
    }
}

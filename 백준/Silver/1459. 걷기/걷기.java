import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());


        long result = 0;
        if (W * 2 <= S) {
            result = (long) (X + Y) * W;
        } else {
            int minValue = Math.min(X, Y);
            int maxValue = Math.max(X, Y);

            int diff = maxValue - minValue;

            result = (long) minValue * S;

            if (W > S) {
                result += (long) (diff / 2) * 2 * S;
                if (diff % 2 == 1) {
                    result += W;
                }
            } else {
                result += (long) (diff) * W;
            }
        }
        System.out.println(result);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()) + 1;
        int N = Integer.parseInt(st.nextToken()) + 1;

        st = new StringTokenizer(br.readLine());
        int sY = Integer.parseInt(st.nextToken());
        int sX = Integer.parseInt(st.nextToken());


        int T = Integer.parseInt(br.readLine());

        int remainX = T % (2 * (N - 1));
        int remainY = T % (2 * (M - 1));


        int x = sX;
        int d = 1;
        for (int i = 0; i < remainX; i++) {
            if (x + d >= N || x + d < 0) {
                d = -1 * d;
            }
            x += d;
        }


        d = 1;
        int y = sY;
        for (int i = 0; i < remainY; i++) {
            if (y + d >= M || y + d < 0) {
                d = -1 * d;
            }
            y += d;
        }

        System.out.println(y + " " + x);
    }
}

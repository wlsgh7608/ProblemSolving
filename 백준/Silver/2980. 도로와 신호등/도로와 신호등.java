import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Signal {
        int d;
        int r;
        int g;

        public Signal(int d, int r, int g) {
            this.d = d;
            this.r = r;
            this.g = g;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Signal[] signals = new Signal[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            signals[i] = new Signal(d, r, g);
        }

        int loc = 0;
        int t = 0;


        for (int i = 0; i < N; i++) {
            Signal cur = signals[i];
            t += cur.d - loc;
            loc = cur.d;
            int tot = cur.g + cur.r;
            if (t % tot < cur.r) {
                t += cur.r - t % tot;
            }
        }
        t += L - signals[N - 1].d;
        System.out.println(t);


    }
}

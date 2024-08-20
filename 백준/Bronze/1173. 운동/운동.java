import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());


        int pulse = m;
        int time = 0;
        int cnt = 0;

        while (cnt < N) {
            if (pulse + T <= M) {
                pulse += T;
                cnt++;
            } else {
                pulse -= R;
                if (pulse < m) {
                    pulse = m;
                }
            }
            time++;
            if (pulse == m && pulse + T > M) {
                time = -1;
                break;
            }
        }
        System.out.println(time);


    }
}

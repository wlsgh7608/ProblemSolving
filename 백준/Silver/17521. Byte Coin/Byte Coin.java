import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        long coin = 0;


        for (int i = 0; i < N - 1; i++) {
            if (arr[i] < arr[i + 1] && W >= arr[i]) { //매수
                coin += (W / arr[i]);
                W %= arr[i];
            } else if (arr[i] > arr[i + 1] && coin != 0) { //매도
                W += (coin * arr[i]);
                coin = 0;
            }
        }

        W += coin * arr[N - 1];

        System.out.println(W);

    }
}

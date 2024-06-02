import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());


        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            arr[i] += arr[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int time = Integer.parseInt(br.readLine());
            int result = N;


            for (int j = 1; j <= N; j++) {
                if (arr[j] > time) {
                    result = j;
                    break;
                }
            }
            sb.append(result).append("\n");
        }


        System.out.println(sb);


    }
}

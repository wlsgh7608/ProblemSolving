import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long getValue(int s, int e, int[] arr) {
        long result = 1;
        for (int i = s; i <= e; i++) {
            result *= arr[i];
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long maxValue = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N - 1; k++) {
                    long result = getValue(0, i, arr)
                            + getValue(i + 1, j, arr)
                            + getValue(j + 1, k, arr)
                            + getValue(k + 1, N - 1, arr);
                    maxValue = Math.max(maxValue, result);
                }
            }
        }
        System.out.println(maxValue);


    }
}

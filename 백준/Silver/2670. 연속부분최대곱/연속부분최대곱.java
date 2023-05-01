import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        double result = 0;

        for (int i = 0; i < N; i++) {
            double max = arr[i];
            double cur = arr[i];
            for (int j = i + 1; j < N; j++) {
                cur *= arr[j];
                if (max < cur) {
                    max = cur;
                }
            }
            if (result < max) {
                result = max;
            }
        }
        String str = String.format("%.3f", result);
        System.out.println(str);
    }
}

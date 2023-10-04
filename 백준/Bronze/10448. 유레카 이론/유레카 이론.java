import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[50];

        for (int i = 1; i < 50; i++) {
            arr[i] = i * (i + 1) / 2;
        }


        boolean[] isTrue = new boolean[1001];


        for (int i = 1; i < 50 && arr[i] <= 1000; i++) {
            for (int j = 1; j < 50 && arr[i] + arr[j] <= 1000; j++) {
                for (int k = 1; k < 50 && arr[i] + arr[j] + arr[k] <= 1000; k++) {
                    int n = arr[i] + arr[j] + arr[k];
                    isTrue[n] = true;
                }
            }
        }


        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            if (isTrue[N]) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }

        }
        System.out.println(sb);

    }
}

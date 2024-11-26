import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean check(int[] arr) {
        int pivot = arr[0];
        for (int n : arr) {
            if (pivot != n) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] % 2 == 1) {
                    arr[i]++;
                }
            }
            int iter = 0;

            while (true) {
                if (check(arr)) {
                    break;
                }
                int[] newArr = new int[N];
                for (int i = 0; i < N; i++) {
                    newArr[i] = arr[(N + i - 1) % N] / 2;
                }
                for (int i = 0; i < N; i++) {
                    newArr[i] += arr[i] / 2;
                    if (newArr[i] % 2 == 1) {
                        newArr[i]++;
                    }
                }
                arr = newArr;
                iter++;
            }
            sb.append(iter).append("\n");


        }
        System.out.println(sb);

    }
}

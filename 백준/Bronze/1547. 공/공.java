import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static void swap(boolean[] arr, int a, int b) {
        boolean temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[4];
        for (int i = 1; i <= 3; i++) {
            arr[i] = false;
        }
        arr[1] = true;
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            swap(arr, a, b);
        }
        for (int i = 1; i <= 3; i++) {
            if (arr[i]) {
                System.out.println(i);
            }
        }
    }
}

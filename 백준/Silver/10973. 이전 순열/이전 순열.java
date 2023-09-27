import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int i = N - 1;
        while (i > 0 && arr[i] > arr[i - 1]) {
            i--;
        }

        if (i == 0) {
            System.out.println(-1);
        } else {
            int j = N - 1;
            while (arr[i - 1] < arr[j]) {
                j--;
            }
            swap(arr, i - 1, j);
            j = N - 1;
            while (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            }

            StringBuilder sb = new StringBuilder();
            for (int n : arr) {
                sb.append(n + " ");
            }
            System.out.println(sb);

        }


    }
}

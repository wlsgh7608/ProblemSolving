import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void mergeSort(int p, int q) {
        if (p < q) {
            int m = (p + q) / 2;
            mergeSort(p, m);
            mergeSort(m + 1, q);
            merge(p, q);
        }

    }

    static void merge(int p, int q) {
        int i = p;
        int m = (p + q) / 2;
        int j = m + 1;
        int t = 0;
        int[] tmp = new int[q - p + 1];

        while (i <= m && j <= q) {
            if (arr[i] < arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }

        }
        while (i <= m) {
            tmp[t++] = arr[i++];
        }
        while (j <= q) {
            tmp[t++] = arr[j++];
        }

        for (i = 0; i < t; i++) {
            arr[p + i] = tmp[i];
            if (++cnt == K) {
                answer = tmp[i];
            }
        }


    }

    static int[] arr;
    static int cnt;
    static int K;
    static int answer = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, N - 1);
        System.out.println(answer);


    }
}

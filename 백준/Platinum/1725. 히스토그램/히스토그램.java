import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;
    static int[] tree;
    static int N;

    static int init(int n, int cl, int cr) {
        if (cl == cr) {

            return tree[n] = cl;
        }
        int m = (cl + cr) / 2;

        int left = init(n * 2, cl, m);
        int right = init(n * 2 + 1, m + 1, cr);
        if (arr[left] <= arr[right]) {
            tree[n] = left;
        } else {
            tree[n] = right;
        }
        return tree[n];
    }

    static int query(int ql, int qr, int n, int cl, int cr) {
        if (qr < cl || ql > cr) {
            return -1;
        }
        if (ql <= cl && cr <= qr) {
            return tree[n];
        }
        int mid = (cl + cr) / 2;
        int left = query(ql, qr, 2 * n, cl, mid);
        int right = query(ql, qr, 2 * n + 1, mid + 1, cr);
        if (left == -1) {
            return right;
        } else if (right == -1) {
            return left;
        }

        if (arr[left] <= arr[right]) {
            return left;
        } else {
            return right;
        }
    }

    static int getMaxSquare(int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return arr[start];
        }

        int minIdx = query(start, end, 1, 0, N - 1);
        int left = getMaxSquare(start, minIdx - 1);
        int right = getMaxSquare(minIdx + 1, end);
        int cur = arr[minIdx] * (end - start + 1);

        return Math.max(Math.max(left, right), cur);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tree = new int[4 * N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(1, 0, N - 1);

        int ans = getMaxSquare(0, N - 1);
        System.out.println(ans);

    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] tree;

    static int calc(int left, int right) {
        if (left == -1) {
            return right;
        } else if (right == -1) {
            return left;
        }

        if (arr[left] < arr[right]) {
            return left;
        }
        return right;
    }

    static int init(int idx, int s, int e) {
        if (s == e) {
            return tree[idx] = s;
        }
        int m = (s + e) / 2;
        int left = init(idx * 2, s, m);
        int right = init(idx * 2 + 1, m + 1, e);
        return tree[idx] = calc(left, right);
    }

    static int query(int ql, int qr, int idx, int tl, int tr) {
        if (qr < tl || tr < ql) {
            return -1;
        }
        if (ql <= tl && tr <= qr) {
            return tree[idx];
        }

        int m = (tl + tr) / 2;
        int left = query(ql, qr, idx * 2, tl, m);
        int right = query(ql, qr, idx * 2 + 1, m + 1, tr);
        return calc(left, right);
    }


    static long getMaxSquare(int s, int e) {
        if (s == e) {
            return arr[s];
        }
        if (s < e) {
            int minIdx = query(s, e, 1, 0, N - 1);
            long left = getMaxSquare(s, minIdx - 1);
            long right = getMaxSquare(minIdx + 1, e);

            long minArea = (long) arr[minIdx] * (e - s + 1);
            long maxValue = Math.max(left, right);
            maxValue = Math.max(maxValue, minArea);
            return maxValue;
        }
        return 0;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            tree = new int[4 * N];
            init(1, 0, N - 1);
            long result = getMaxSquare(0, N - 1);
            sb.append(result).append("\n");
        }//end while

        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] tree;

    static int calc(int a, int b) {

        if (arr[a] < arr[b]) {
            return a;
        } else if (arr[a] == arr[b]) {
            return a < b ? a : b;
        } else {
            return b;
        }
    }

    static int init(int tn, int ql, int qr) {
        if (ql == qr) {
            return tree[tn] = ql;
        }

        int m = (ql + qr) / 2;


        int left = init(tn * 2, ql, m);
        int right = init(tn * 2 + 1, m + 1, qr);
        return tree[tn] = calc(left, right);


    }

    static int update(int uIdx, int uValue, int tn, int ql, int qr) {
        if (ql == qr && ql == uIdx) {
            arr[uIdx] = uValue;
            return uIdx;
        }
        if (ql > uIdx || qr < uIdx) {
            return tree[tn];
        }


        int m = (ql + qr) / 2;
        int left = update(uIdx, uValue, 2 * tn, ql, m);
        int right = update(uIdx, uValue, 2 * tn + 1, m + 1, qr);
        return tree[tn] = calc(left, right);
    }


    static int query(int ql, int qr, int tn, int cl, int cr) {
        if (qr < cl || cr < ql) {
            return 0;
        }

        if (cl <= ql && qr <= qr) {
            return tree[tn];
        }
        int m = (cl + cr) / 2;
        int left = query(ql, qr, 2 * tn, cl, m);
        int right = query(ql, qr, 2 * tn + 1, m + 1, cr);
        return calc(left, right);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tree = new int[4 * N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[0] = Integer.MAX_VALUE;

        int qN = Integer.parseInt(br.readLine());

        init(1, 1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < qN; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            if (p == 2) {
                int ans = query(1, N, 1, 1, N);
                sb.append(ans).append("\n");
            } else {
                int uIdx = Integer.parseInt(st.nextToken());
                int uValue = Integer.parseInt(st.nextToken());
                update(uIdx, uValue, 1, 1, N);
            }
        } // end for
        System.out.println(sb);

    }

}

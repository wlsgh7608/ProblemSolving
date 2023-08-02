import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int calc(int a, int b) {
        return a + b;
    }

    static int query(int s, int e, int idx, int treeL, int treeR) {
        if (e < treeL || treeR < s) {
            return DEFAULT;
        }

        if (s <= treeL && treeR <= e) {
            return tree[idx];
        }

        int m = (treeL + treeR) / 2;
        int left = query(s, e, idx * 2, treeL, m);
        int right = query(s, e, idx * 2 + 1, m + 1, treeR);
        return calc(left, right);
    }

    static int update(int uI, int idx, int treeL, int treeR) {
        if (uI < treeL || treeR < uI) {
            return tree[idx];
        }
        if (treeL == treeR) {
            return tree[idx] = 0;
        }

        int m = (treeL + treeR) / 2;
        int left = update(uI, idx * 2, treeL, m);
        int right = update(uI, idx * 2 + 1, m + 1, treeR);
        return tree[idx] = calc(left, right);
    }

    static int init(int s, int e, int idx) {
        if (s == e) {
            return tree[idx] = 1;
        }
        int m = (s + e) / 2;
        int left = init(s, m, idx * 2);
        int right = init(m + 1, e, idx * 2 + 1);
        return tree[idx] = calc(left, right);
    }

    static final int DEFAULT = 0;
    static int[] tree;
    static int[] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tree = new int[4 * N];

        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[n] = i;
        }
        init(1, N, 1);
        StringBuilder sb = new StringBuilder();
        int p = 0;
        int q = N+1;


        for (int i = 1; i <= N; i++) {
            // 왼쪽으로
            if (i % 2 == 1) {
                p++;
                int qIdx = arr[p];
                update(qIdx, 1, 1, N);
                sb.append(query(1, qIdx, 1, 1, N));
            }
            // 오른쪽으로
            else {
                q--;
                int qIdx = arr[q];
                update(qIdx, 1, 1, N);
                sb.append(query(qIdx, N, 1, 1, N));
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }
}

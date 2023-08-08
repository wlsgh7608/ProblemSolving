import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int calc(int a, int b) {
        return a + b;
    }

    static int init(int idx, int treeL, int treeR) {
        if (treeL == treeR) {
            return tree[idx] = 1;
        }
        int m = (treeL + treeR) / 2;
        int left = init(idx * 2, treeL, m);
        int right = init(idx * 2 + 1, m + 1, treeR);
        return tree[idx] = calc(left, right);
    }

    static int update(int uI, int uV, int idx, int treeL, int treeR) {
        if (uI < treeL || treeR < uI) {
            return tree[idx];
        }
        if (treeL == treeR) {
            return tree[idx] = uV;
        }
        int m = (treeL + treeR) / 2;
        int left = update(uI, uV, idx * 2, treeL, m);
        int right = update(uI, uV, idx * 2 + 1, m + 1, treeR);
        return tree[idx] = calc(left, right);
    }

    static int query(int qL, int qR, int idx, int treeL, int treeR) {
        // 벗어난 경우
        if (treeR < qL || qR < treeL) {
            return 0;
        }
        // 사이에 있는 경우
        if (qL <= treeL && treeR <= qR) {
            return tree[idx];
        }
        int m = (treeL + treeR) / 2;
        int left = query(qL, qR, idx * 2, treeL, m);
        int right = query(qL, qR, idx * 2 + 1, m + 1, treeR);
        return calc(left, right);
    }

    static int[] tree;
    static int MAX;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] curIdx = new int[N + 1];

            int p = 1;
            for (int i = N; i > 0; i--, p++) {
                curIdx[i] = p;
            }
            int Q = Integer.parseInt(st.nextToken());
            MAX = N + Q;
            tree = new int[4 * MAX];
            init(1, 1, MAX);

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < Q; i++) {
                int n = Integer.parseInt(st.nextToken());
                int qIdx = curIdx[n];
                int newIDx = N + 1 + i;
                int result = query(qIdx + 1, N + i, 1, 1, MAX);
                sb.append(result).append(" ");
                update(qIdx, 0, 1, 1, MAX); // 해당 층 0으로
                curIdx[n] = newIDx;
                update(newIDx, 1, 1, 1, MAX); // 새로운 층 1으로
            }
            sb.append("\n");

        }// end T for
        System.out.println(sb);
    }
}

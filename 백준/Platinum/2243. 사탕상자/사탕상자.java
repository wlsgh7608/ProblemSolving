import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int calc(int a, int b) {
        return a + b;
    }

    static int query(int s, int e, int idx, int rank) {
        if (s == e) {
            return s;
        }

        int m = (s + e) / 2;
        int left = tree[idx * 2];
        if (rank <= left) {
            return query(s, m, idx * 2, rank);
        } else {
            return query(m + 1, e, idx * 2 + 1, rank - left);
        }


    }

    static int update(int uI, int uV, int idx, int treeL, int treeR) {
        if (uI < treeL || treeR < uI) {
            return tree[idx];
        }
        if (treeL == treeR) {
            tree[idx] += uV;
            return tree[idx];
        }
        int m = (treeL + treeR) / 2;
        int left = update(uI, uV, idx * 2, treeL, m);
        int right = update(uI, uV, idx * 2 + 1, m + 1, treeR);
        return tree[idx] = calc(left, right);
    }


    static int[] tree;
    static final int DEAFULT = 0;
    static final int SIZE = 1_000_001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        tree = new int[SIZE * 4];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int result = query(1, SIZE, 1, b);
                sb.append(result).append("\n");
                update(result, -1, 1, 1, SIZE);
            } else {
                int c = Integer.parseInt(st.nextToken());
                update(b, c, 1, 1, SIZE);
            }
        }
        System.out.println(sb);
    }
}

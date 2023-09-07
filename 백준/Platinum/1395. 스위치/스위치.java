import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] tree;
    static boolean[] lazy;

    // propagate
    static void propagate(int idx, int nl, int nr) {
        int m = (nl + nr) / 2;
        pushDown(idx * 2, nl, m);
        pushDown(idx * 2 + 1, m + 1, nr);
        lazy[idx] = false;
    }


    // calc // ?
    // sum?
    static int calc(int a, int b) {
        return a + b;
    }

    // mergeblock

    static void pushDown(int idx, int nl, int nr) {
        int size = nr - nl + 1;
        // leaf node
        if (nl == nr) {
            // 변환
            tree[idx] ^= 1;
            return;
        }

        tree[idx] = size - tree[idx];
        lazy[idx] = !lazy[idx];
    }

    static int update(int s, int e, int idx, int nl, int nr) {
        if (nr < s || e < nl) {
            return tree[idx];
        }
        // left
        if (nl == nr) {
            return tree[idx] ^= 1;
        }
        // 범위 내에 존재
        if (s <= nl && nr <= e) {
            int size = nr - nl + 1;
            tree[idx] = size - tree[idx];
            lazy[idx] = !lazy[idx];
            return tree[idx];

        }
        int m = (nl + nr) / 2;
        if (lazy[idx]) {
            propagate(idx, nl, nr);
        }
        int left = update(s, e, idx * 2, nl, m);
        int right = update(s, e, idx * 2 + 1, m + 1, nr);
        return tree[idx] = calc(left, right);
    }


    static int query(int s, int e, int idx, int nl, int nr) {
        if (e < nl || nr < s) {
            return 0;
        }
        if (s <= nl && nr <= e) {
            return tree[idx];
        }
        int m = (nl + nr) / 2;
        if (lazy[idx]) {
            propagate(idx, nl, nr);
        }

        int left = query(s, e, idx * 2, nl, m);
        int right = query(s, e, idx * 2 + 1, m + 1, nr);
        return calc(left, right);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        tree = new int[4 * (N + 1)]; // 범위 내 켜져 있는 스위치 개수
        lazy = new boolean[4 * (N + 1)];


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0) {
                //switch
                update(b, c, 1, 1, N);
            } else {
                //query
                int result = query(b, c, 1, 1, N);
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);

    }
}

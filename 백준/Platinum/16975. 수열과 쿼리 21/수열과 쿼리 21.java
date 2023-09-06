import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final static long DEFAULT = 0;

    static long calc(long a, long b) {
        return a + b;
    }

    static long merge(long addValue, int size) {
        return addValue * size;
    }

    static long init(int idx, int nl, int nr) {
        if (nl == nr) {
            return tree[idx] = arr[nl];
        }

        int m = (nl + nr) / 2;
        long left = init(idx * 2, nl, m);
        long right = init(idx * 2 + 1, m + 1, nr);
        return tree[idx] = calc(left, right);
    }

    static long pushDown(long addValue, int idx, int nl, int nr) {
        // leaf 노드인 경우
        if (nl == nr) {
            return tree[idx] += addValue;
        }
        int size = nr - nl + 1;
        lazyValue[idx] += addValue;
        tree[idx] += merge(addValue, size);
        return tree[idx];
    }

    static long update(int s, int e, int addV, int idx, int nl, int nr) {
        // 벗어난 경우
        if (nr < s || e < nl) {
            return tree[idx];
        }
        if (nl == nr) {
            return tree[idx] += addV;
        }
        // 모두 포함
        if (s <= nl && nr <= e) {
            lazyValue[idx] += addV;
            int size = (nr - nl + 1);
            return tree[idx] += merge(addV, size);
        }
        int m = (nl + nr) / 2;
        // pushDown
        if (lazyValue[idx] != 0) {
            pushDown(lazyValue[idx], idx * 2, nl, m);
            pushDown(lazyValue[idx], idx * 2 + 1, m + 1, nr);
            lazyValue[idx] = 0;
        }
        long left = update(s, e, addV, idx * 2, nl, m);
        long right = update(s, e, addV, idx * 2 + 1, m + 1, nr);
        return tree[idx] = calc(left, right);
    }

    static long query(int q, int idx, int nl, int nr) {
        if (nr < q || q < nl) {
            return DEFAULT;
        }
        if (q <= nl && nr <= q) {
            return tree[idx];
        }
        int m = (nl + nr) / 2;
        //pushDown
        if (lazyValue[idx] != 0) {
            pushDown(lazyValue[idx], idx * 2, nl, m);
            pushDown(lazyValue[idx], idx * 2 + 1, m + 1, nr);
            lazyValue[idx] = 0;
        }
        long left = query(q, idx * 2, nl, m);
        long right = query(q, idx * 2 + 1, m + 1, nr);
        return calc(left, right);
    }


    static long[] tree;
    static long[] arr;
    static long[] lazyValue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];
        tree = new long[4 * (N + 1)];
        lazyValue = new long[4 * (N + 1)];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(1, 1, N);
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            if (q == 1) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int u = Integer.parseInt(st.nextToken());
                update(s, e, u, 1, 1, N);
            } else {
                int b = Integer.parseInt(st.nextToken());
                long result = query(b, 1, 1, N);
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }
}

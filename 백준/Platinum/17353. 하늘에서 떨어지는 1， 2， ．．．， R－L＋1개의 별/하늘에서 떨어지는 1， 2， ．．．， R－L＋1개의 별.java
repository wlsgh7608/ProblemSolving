import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //calc
    static long calc(long a, long b) {
        return a + b;
    }

    //mergeBlock
    static long merge(long s, long d, int size) {
        long start = s;
        long end = (size - 1) * d + s;

        long result = size * (start + end) / 2;
        return result;
    }

    //pushDown
    static long pushDown(long s, long d, int idx, int nl, int nr) {
        if (nl == nr) {
            return tree[idx] += s;
        }
        lazy[idx] += s;
        diff[idx] += d;
        int size = nr - nl + 1;
        return tree[idx] += merge(s, d, size);
    }

    //update
    static long update(int s, int e, int idx, int nl, int nr) {
        if (nr < s || e < nl) {
            return tree[idx];
        }
        if (nl == nr) {
            return tree[idx] += nl - s + 1;
        }
        if (s <= nl && nr <= e) {
            lazy[idx] += nl - s + 1;
            diff[idx]++;
            tree[idx] += merge(lazy[idx], diff[idx], nr - nl + 1);
            return tree[idx];
        }

        int m = (nl + nr) / 2;
        if (lazy[idx] > 0) {
            propagate(idx, nl, nr);
        }
        long left = update(s, e, idx * 2, nl, m);
        long right = update(s, e, idx * 2 + 1, m + 1, nr);
        return tree[idx] = calc(left, right);
    }

    //query
    static long query(int a, int idx, int nl, int nr) {
        if (a < nl || nr < a) {
            return 0;
        }
        if (a <= nl && nr <= a) {
            return tree[idx];
        }
        int m = (nl + nr) / 2;
        if (lazy[idx] > 0) {
            propagate(idx, nl, nr);
        }
        long left = query(a, idx * 2, nl, m);
        long right = query(a, idx * 2 + 1, m + 1, nr);
        return calc(left, right);
    }


    //propagate
    static void propagate(int idx, int nl, int nr) {
        int m = (nl + nr) / 2;
        pushDown(lazy[idx],diff[idx], idx * 2, nl, m);
        pushDown(lazy[idx] + (m + 1 - nl) * diff[idx],diff[idx], idx * 2 + 1, m + 1, nr);

        lazy[idx] = 0;
        diff[idx] = 0;
    }

    //init
    static long init(int idx, int nl, int nr) {
        // leaf node
        if (nl == nr) {
            return tree[idx] = arr[nl];
        }
        int m = (nl + nr) / 2;
        long left = init(idx * 2, nl, m);
        long right = init(idx * 2 + 1, m + 1, nr);
        return tree[idx] = calc(left, right);

    }

    static long[] arr;
    static long[] tree;
    static long[] lazy; // 초항
    static long[] diff; // 공차

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[N + 1];
        tree = new long[4 * (N + 1)];
        lazy = new long[4 * (N + 1)];
        diff = new long[4 * (N + 1)];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(1, 1, N);

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                // update
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                update(b, c, 1, 1, N);

            } else {
                // query
                int b = Integer.parseInt(st.nextToken());
                long result = query(b, 1, 1, N);
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);

    }
}

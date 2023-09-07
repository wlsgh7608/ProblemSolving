import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] tree;
    static int[] lazy;
    static final int DEFAULT = 0;

    static int calc(int a, int b) {
        return a ^ b;
    }

    static int merge(int idx, int k , int size){
        if(size%2!=0){
            return tree[idx]^=k;
        }
        return tree[idx];
    }


    static int init(int idx, int nl, int nr) {
        if (nl == nr) {
            return tree[idx] = arr[nl];
        }
        int m = (nl + nr) / 2;
        int left = init(idx * 2, nl, m);
        int right = init(idx * 2 + 1, m + 1, nr);
        return tree[idx] = calc(left, right);
    }

    static int update(int s, int e, int k, int idx, int nl, int nr) {
        if (e < nl || nr < s) {
            return tree[idx];
        }

        if (nl == nr) {
            return tree[idx] = calc(tree[idx], k);
        }
        if (s <= nl && nr <= e) {
            lazy[idx] ^= k;
            return tree[idx] = merge(idx, k, nr - nl + 1);
        }
        int m = (nl + nr) / 2;
        if (lazy[idx] != 0) {
            propagate(idx, nl, nr);
        }
        int left = update(s, e, k, idx * 2, nl, m);
        int right = update(s, e, k, idx * 2 + 1, m + 1, nr);
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
        if (lazy[idx] != 0) {
            propagate(idx, nl, nr);
        }
        int left = query(s, e, idx * 2, nl, m);
        int right = query(s, e, idx * 2 + 1, m + 1, nr);
        return calc(left, right);
    }

    static void propagate(int idx, int nl, int nr) {
        int m = (nl + nr) / 2;
        pushDown(lazy[idx], idx * 2, nl, m);
        pushDown(lazy[idx], idx * 2 + 1, m + 1, nr);
        lazy[idx] = 0;
    }

    static int pushDown(int k, int idx, int nl, int nr) {
        if (nl == nr) {
            return tree[idx] ^= k;
        }
        lazy[idx] ^= k;
        return tree[idx] = merge(idx, k, nr - nl + 1);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        tree = new int[4 * N];
        lazy = new int[4 * N];
        init(1, 0, N - 1);
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                update(b, c, d, 1, 0, N - 1);
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int result = query(b, c, 1, 0, N - 1);
                sb.append(result).append("\n");
            }
        } // end while
        System.out.println(sb);


    }
}

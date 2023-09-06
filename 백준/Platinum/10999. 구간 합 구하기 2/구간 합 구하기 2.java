import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long[] tree;
    static long[] arr;
    static long[] lazyValue;
    static final long DEFAULT = 0;


    static long calc(long a, long b) {
        return a + b;
    }

    static long merge(long value, int size) {
        return value * size;
    }

    static long init(int idx,int nl,int nr){
        if(nl==nr){
            return tree[idx] = arr[nl];
        }
        int m = (nl+nr)/2;
        long left = init(idx * 2, nl, m);
        long right = init(idx * 2+1, m + 1, nr);
        return tree[idx] = calc(left, right);
    }

    static long pushDown(long addV, int idx, int nl, int nr) {
        // leaf node
        if (nl == nr) {
            return tree[idx] += addV;
        }
        lazyValue[idx] += addV;
        int size = nr - nl + 1;
        return tree[idx] += merge(addV, size);
    }

    static long update(int s, int e, long uV, int idx, int nl, int nr) {
        if (nr < s || e < nl) {
            return tree[idx];
        }

        if(s<=nl && nr<=e){
            lazyValue[idx] += uV;
            int size = nr - nl + 1;
            return tree[idx] += merge(uV, size);
        }
        int m = (nl+nr)/2;
        if(lazyValue[idx]!=0){
            pushDown(lazyValue[idx], idx * 2, nl, m);
            pushDown(lazyValue[idx], idx * 2+1, m+1, nr);
            lazyValue[idx] = 0;
        }
        long left = update(s, e, uV, idx * 2, nl, m);
        long right = update(s, e, uV, idx * 2 + 1, m + 1, nr);
        return tree[idx] = calc(left, right);
    }

    static long query(int s,int e,int idx ,int nl,int nr) {
        if(e<nl || nr<s){
            return DEFAULT;
        }

        if(s<=nl && nr <=e){
            return tree[idx];
        }
        int m = (nl+nr)/2;
        if (lazyValue[idx] != 0) {
            pushDown(lazyValue[idx], idx * 2, nl, m);
            pushDown(lazyValue[idx], idx * 2+1, m+1, nr);
            lazyValue[idx] = 0;
        }
        long left = query(s, e, idx * 2, nl, m);
        long right = query(s, e, idx * 2 + 1, m + 1, nr);
        return calc(left, right);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        tree = new long[4 * (N + 1)];
        lazyValue = new long[4 * (N + 1)];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, 1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken());
                update(b, c, d, 1, 1, N);

            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long result = query(b, c, 1, 1, N);
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] arr;
    static int[] tree;
    static long[] sum;
    static int N;

    static int calc(int a, int b) {
        long aValue = arr[a];
        long bValue = arr[b];
        if (aValue < bValue) {
            return a;
        } else {
            return b;
        }
    }

    static int init(int leftIdx, int rightIdx, int no) {
        if (leftIdx == rightIdx) {
            return tree[no] = leftIdx;
        }
        int m = (leftIdx + rightIdx) / 2;
        int left = init(leftIdx, m, 2 * no);
        int right = init(m + 1, rightIdx, 2 * no + 1);
        tree[no] = calc(left, right);

        return tree[no];
    }

    static int  query(int ql, int qr, int tl, int tr, int no) {
        if (ql > tr || qr < tl) {
            return 0;
        }

        if (ql <= tl && tr <= qr) {
            return tree[no];
        }
        int m = (tl + tr) / 2;
        int left = query(ql, qr, tl, m, no * 2);
        int right = query(ql, qr, m + 1, tr, no * 2 + 1);
        return calc(left, right);
    }


    static long process(int left, int right) {
        if(left==right){
            return arr[left]*arr[left];
        }
        if(left<1 || right>N || left>right){
            return 0;
        }
        int minIdx = query(left, right, 1, N , 1);
        long sumValue = sum[right] - sum[left - 1];
        long currentValue = sumValue * arr[minIdx];
        long leftValue = process(left, minIdx - 1);
        long righValue = process(minIdx + 1, right);
        long maxValue = Math.max(currentValue, leftValue);

        maxValue = Math.max(maxValue, righValue);
        return  maxValue;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Long.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        sum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = arr[i] + sum[i - 1];
        }

        tree = new int[4 * N];
        init(1, N , 1);
        long answer = process(1, N);
        System.out.println(answer);
    }
}

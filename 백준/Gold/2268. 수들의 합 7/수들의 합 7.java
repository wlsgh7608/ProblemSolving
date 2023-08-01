import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long calc(long a, long b) {
        return a + b;
    }

    static long query(int s, int e, int idx, int treeL, int treeR) {
        if (e < treeL || treeR < s) {
            return DEFAULT;
        }
        if (s <= treeL && treeR <=e) {
            return tree[idx];
        }
        int m = (treeL + treeR) / 2;
        long left = query(s, e, idx * 2, treeL, m);
        long right = query(s, e, idx * 2 + 1, m + 1, treeR);
        return calc(left, right);
    }

    static long update(int uI,int uV,int idx ,int treeL,int treeR) {
        if(uI<treeL || uI>treeR){
            return tree[idx];
        }
        if(treeL==treeR){
            return tree[idx] = uV;
        }

        int m = (treeL + treeR) / 2;
        long left = update(uI, uV, idx * 2, treeL, m);
        long right = update(uI, uV, idx * 2 + 1, m + 1, treeR);
        return tree[idx] = calc(left, right);
    }

    static long[] tree;
    static final long DEFAULT = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        tree = new long[4 * N + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            switch (a) {
                case 0:
                    int minV = Math.min(b, c);
                    int maxV = Math.max(b, c);

                    long result = query(minV, maxV,1,1,N);
                    sb.append(result).append("\n");
                    break;

                case 1:
                    update(b, c, 1, 1, N);
                    break;
            }
        } // end for
        System.out.println(sb);


    }
}

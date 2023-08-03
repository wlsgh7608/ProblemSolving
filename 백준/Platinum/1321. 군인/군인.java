import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] tree;

    static int calc(int a, int b){
        return a + b;
    }
    static int init(int s, int e, int idx) {
        if (s == e) {
            return tree[idx] = arr[s];
        }
        int m = (s + e) / 2;
        int left = init(s, m, idx * 2);
        int right = init(m + 1, e, idx * 2 + 1);
        return tree[idx] = calc(left ,right);
    }

    static int query(int s,int e, int n,int idx){
        if(s==e){
            return s;
        }
        int m = (s + e) / 2;
        int left = tree[idx * 2];
        if(n<=left){
            return query(s, m, n, idx * 2);
        }else{
            return query(m + 1, e, n - left, idx * 2 + 1);
        }
    }

    static int update(int uI, int uV, int idx,int treeL,int treeR){
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tree = new int[4 * N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1 ; i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(1,N,1);
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i= 0 ; i<Q;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==1){
                int c = Integer.parseInt(st.nextToken());
                update(b, c, 1, 1, N);
            }else{
                int result = query(1, N, b, 1);
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);

    }
}

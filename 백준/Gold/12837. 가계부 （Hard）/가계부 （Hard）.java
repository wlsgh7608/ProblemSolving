import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long calc(long a, long b){
        return a+b;
    }


    static long update(int idx, int addN,int  nodeN, int treeL,int treeR){
        if(idx<treeL || idx>treeR){
            return tree[nodeN];
        }
        if(treeL==treeR){
            tree[nodeN] += addN;
            return tree[nodeN];
        }
        int m = (treeL+treeR)/2;

        long left = update(idx, addN, nodeN * 2, treeL, m);
        long right = update(idx, addN, nodeN * 2+1, m+1, treeR);

        return tree[nodeN] = calc(left, right);
    }

    static long query(int queryL,int queryR,int nodeN,int treeL,int treeR){
        if(queryR<treeL || queryL > treeR){
            return 0;
        }
        if(queryL<=treeL && queryR>=treeR){
            return tree[nodeN];
        }
        int m = (treeL+treeR)/2;
        long left = query(queryL, queryR, 2 * nodeN, treeL, m);
        long right = query(queryL, queryR, 2 * nodeN+1, m+1, treeR);
        return calc(left, right);

    }

    static long[] tree;



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        tree = new long[4 * N + 1];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<Q;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            switch(a){
                case 1:
                    update(b, c, 1, 1, N);
                    break;
                case 2:
                    long result = query(b, c, 1, 1, N);
                    sb.append(result).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}

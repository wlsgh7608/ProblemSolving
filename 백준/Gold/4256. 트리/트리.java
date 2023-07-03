import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static void dfs(int s, int e, int leftCnt,int depth) {

        if(s>e){
            return;
        }
        int rootNum = preOrders[s];
        int rootIdx = -1;
        for (int i=  s-leftCnt;i<=e-leftCnt;i++){
            if(inOrders[i]==rootNum){
                rootIdx = i;
            }
        } // find
        dfs(s+1, leftCnt+rootIdx, leftCnt + 1,depth+1);
        dfs(leftCnt+rootIdx+1 , e, leftCnt,depth+1);
        postOrders[e-depth] = rootNum;

    }

    static int[] preOrders;
    static int[] inOrders;
    static int[] postOrders;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            preOrders = new int[N];
            inOrders = new int[N];
            postOrders = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                preOrders[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                inOrders[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, N - 1, 0,0);


//            System.out.println(Arrays.toString(postOrders));
            for(int n: postOrders){
                sb.append(n + " ");
            }
            sb.append("\n");
        }// end for
        System.out.println(sb);

    }
}

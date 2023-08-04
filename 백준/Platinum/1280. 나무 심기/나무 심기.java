import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int calcCount(int a, int b) {
        return a + b;
    }


    static long calcSum(long a, long b) {
        return a + b;
    }




    static int queryCnt(int start,int end,int idx,int treeL, int treeR){
        if(end<treeL || start>treeR){
            return 0;
        }
        if(start <= treeL && treeR <=end){
            return countTree[idx];
        }
        int m = (treeL + treeR) / 2;
        int left = queryCnt(start, end, idx * 2, treeL, m);
        int right = queryCnt(start, end, idx * 2 + 1, m + 1, treeR);
        return calcCount(left, right);
    }


    static long querySum(int start,int end , int idx, int treeL, int treeR) {
        if(end<treeL || start>treeR){
            return 0;
        }
        if(start <= treeL && treeR <=end){
            return sumTree[idx];
        }
        int m = (treeL + treeR) / 2;
        long left = querySum(start, end, idx * 2, treeL, m);
        long right = querySum(start, end, idx * 2 + 1, m + 1, treeR);
        return calcSum(left, right);


    }

    static long updateSum(int uN, int idx, int treeL, int treeR) {
        if (uN < treeL|| treeR < uN) {
            return sumTree[idx];
        }
        if (treeL == treeR) {
            sumTree[idx] += treeL;
            return sumTree[idx] ;
        }
        int m = (treeL + treeR) / 2;
        long left = updateSum(uN, idx * 2, treeL, m);
        long right = updateSum(uN, idx * 2 + 1, m + 1, treeR);
        return sumTree[idx] = calcSum(left, right);
    }

    static int updateCount(int uN, int idx, int treeL, int treeR) {
        if (uN < treeL|| treeR < uN) {
            return countTree[idx];
        }
        if (treeL == treeR) {
            countTree[idx]+=1;
            return countTree[idx];
        }
        int m = (treeL + treeR) / 2;
        int left = updateCount(uN, idx * 2, treeL, m);
        int right = updateCount(uN, idx * 2 + 1, m + 1, treeR);
        return countTree[idx] = calcCount(left, right);
    }


    static long[] sumTree;
    static int[] minTree;
    static int[] countTree;
    static final int MAX = 200_000;
    static final long MOD = 1_000_000_007;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        countTree = new int[4 * (MAX+1)];
        minTree = new int[4 * (MAX+1)];
        sumTree = new long[4 * (MAX+1)];

        long result = 1;
        int first = Integer.parseInt(br.readLine());
        updateCount(first, 1, 0, MAX);
        updateSum(first, 1, 0, MAX);
        for(int i = 1 ;i<N;i++){
            long temp = 0;
            int n = Integer.parseInt(br.readLine());
            temp += 1L *n * queryCnt(0, n - 1, 1, 0, MAX) - querySum(0, n - 1, 1, 0, MAX);
            temp += querySum(n+1, MAX, 1, 0, MAX) - 1L*n*queryCnt(n+1, MAX, 1, 0, MAX);
            updateCount(n, 1, 0, MAX);
            updateSum(n, 1, 0, MAX);
            temp %= MOD;
            result = (result * temp) % MOD;

        }
        System.out.println(result);


    }
}

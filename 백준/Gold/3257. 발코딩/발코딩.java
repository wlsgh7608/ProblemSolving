import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    static char[] input;

    static int lenA;
    static int lenB;
    static int[][] dp;

    static String ans = null;

    static  void traverse(int x, int y, StringBuilder sb){
        if(x==0 && y==0){
            return;
        }

        if(dp[x][y]==1){
            traverse(x-1,y,sb);
        }

        if(dp[x][y] ==2){
            traverse(x,y-1,sb);
        }
        sb.append(dp[x][y]);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();


        lenA = A.length;
        lenB = B.length;
        input = br.readLine().toCharArray();
        dp = new int[lenA + 1][lenB + 1];


        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        dp[0][0] = 0;

        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i > 0 && dp[i - 1][j] != -1 && input[i + j - 1] == A[i-1]) {
                    dp[i][j] = 1;
                }

                if (j > 0 && dp[i][j - 1] != -1 && input[i + j - 1] == B[j-1]) {
                    dp[i][j] = 2;
                }


            }
        }

        StringBuilder sb = new StringBuilder();

        traverse(lenA, lenB, sb);

        System.out.println(sb);

    }
}

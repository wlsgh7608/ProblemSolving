import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static boolean isTrue(String N, boolean[][] canUse) {
        int first = N.charAt(0) - '0';
        int last = N.charAt(N.length() - 1) - '0';


        // 1번
        if (first != 1 || last != 2) {
            return false;
        }

        //2번
        int prev = N.charAt(0) - '0';

        for (int i = 1; i < N.length(); i++) {
            int cur = N.charAt(i) - '0';
            if (canUse[prev][cur]) {
                prev = cur;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int t = 1;
        StringBuilder sb = new StringBuilder();

        boolean[][] canUse = new boolean[9][9];
        canUse[1][4] = true;
        canUse[1][5] = true;
        canUse[3][4] = true;
        canUse[3][5] = true;
        canUse[4][2] = true;
        canUse[4][3] = true;
        canUse[5][8] = true;
        canUse[6][2] = true;
        canUse[6][3] = true;
        canUse[7][8] = true;
        canUse[8][6] = true;
        canUse[8][7] = true;

        while (!N.equals("0")) {
            sb.append(t + ". ");
            if (isTrue(N, canUse)) {
                sb.append("VALID");
            } else {
                sb.append("NOT");
            }
            sb.append("\n");

            N = br.readLine();
            t++;
        } // end while
        System.out.println(sb);

    }
}

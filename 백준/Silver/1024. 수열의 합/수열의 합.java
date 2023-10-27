import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // return 값 : 첫째 항
    static int isPossible(int S, int l) {
        int up = 2 * S - l * (l - 1);
        int down = 2 * l;

        if (up % down == 0) {
            return up / down;
        } else {
            return -1;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int n = L;
        for (n = L; n <= 100; n++) {
            int result = isPossible(S, n);
            if (result >= 0) {
                for (int j = 0; j < n; j++) {
                    sb.append((result + j)).append(" ");
                }
                break;
            }
        }
        if(n>100){
            sb.append("-1");
        }
        System.out.println(sb);


    }
}

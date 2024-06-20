import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxdiff = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int M = 0;
        int W = 0;


        boolean cantM = false;
        boolean cantW = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'M') {
                if (Math.abs(M + 1 - W) <= maxdiff) {
                    M++;
                } else {
                    if (cantM) {
                        break;
                    }
                    cantM = true;
                }
            } else {
                if (Math.abs(W + 1 - M) <= maxdiff) {
                    W++;
                } else {
                    if (cantW) {
                        break;
                    }
                    cantW = true;
                }
            }

            if (cantM && Math.abs(M + 1 - W) <= maxdiff) {
                M++;
                cantM = false;
            }

            if (cantW && Math.abs(W + 1 - M) <= maxdiff) {
                W++;
                cantW = false;
            }
        }
        System.out.println(M + W);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int N = Integer.parseInt(str);
        int start = (int) Math.pow(10, len-1);
        int cnt = 0;
        cnt += (N - start + 1) * len;
        int[] p = new int[8];
        for (int i = 0; i < 8; i++) {
            p[i] = 9*(int)Math.pow(10,i);
        }

        for (int i = 0; i < len-1; i++) {
            cnt += (i + 1) * p[i];
        }
        System.out.println(cnt);

    }
}

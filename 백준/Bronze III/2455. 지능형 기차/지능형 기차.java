import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int cur = 0;

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cur -= Integer.parseInt(st.nextToken());
            cur += Integer.parseInt(st.nextToken());
            max = Math.max(max, cur);
        }
        System.out.println(max);
    }
}

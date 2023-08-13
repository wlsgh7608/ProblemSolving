import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int fn = n * a1 + a2;
        int gn = c * n;
        if (fn <= gn) {
            if (100 * a1 + a2 <= c * 100) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        } else {
            System.out.println(0);
        }
    }
}

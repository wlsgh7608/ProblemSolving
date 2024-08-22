import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int x1 = (-A - (int) Math.sqrt(A * A - B));
        int x2 = (-A + (int) Math.sqrt(A * A - B));

        if (x1 == x2) {
            System.out.println(x1);
        } else {
            System.out.println(x1 + " " + x2);
        }


    }
}

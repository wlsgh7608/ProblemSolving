import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        long d = Integer.parseInt(st.nextToken());


        long aResult = a * k + b;
        long bResult = c * k + d;

        if (aResult == bResult) {
            System.out.println("Yes " + aResult);
        } else {
            System.out.println("No");
        }
    }
}

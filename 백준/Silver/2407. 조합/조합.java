import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;

        for (int i = 0; i < M; i++) {
            a = a.multiply(new BigInteger(String.valueOf(N - i)));
            b = b.multiply(new BigInteger(String.valueOf(1 + i)));
        }

        BigInteger result = a.divide(b);
        System.out.println(result);


    }
}

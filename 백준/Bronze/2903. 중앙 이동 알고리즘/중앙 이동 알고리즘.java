import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int len = 2;
        for (int i = 0; i < N; i++) {
            len = len * 2 - 1;
        }
        int result = len * len;
        System.out.println(result);
    }
}

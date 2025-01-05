import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int H = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int result = H * 60 + M;
        System.out.println(result);
    }
}

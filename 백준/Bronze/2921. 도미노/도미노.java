import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 0 ;i<=N;i++){
            for(int j = i; j<=N;j++){
                sum += i+j;
            }
        }
        System.out.println(sum);

    }
}

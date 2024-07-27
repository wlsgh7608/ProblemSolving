import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int K = Integer.parseInt(br.readLine());
            for(int j=0; j<K; j++){
                sb.append("=");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

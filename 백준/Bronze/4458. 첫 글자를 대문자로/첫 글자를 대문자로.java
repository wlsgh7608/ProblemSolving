import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i<N;i++){
            String str = br.readLine();
            sb.append(str.substring(0, 1).toUpperCase() + str.substring(1)).append("\n");

        }
        System.out.println(sb);
    }
}

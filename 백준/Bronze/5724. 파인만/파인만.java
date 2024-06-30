import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();



        while (true){
            int N = Integer.parseInt(br.readLine());
            if(N==0){
                break;
            }
            int ans = 0;
            while(N>0){
                ans+= N*N;
                N--;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }

}

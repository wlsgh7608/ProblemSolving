import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<N;i++){
            int n = Integer.parseInt(br.readLine());
            if(n%2==0){
                sb.append(n + " is even").append("\n");
            }else{
                sb.append(n + " is odd").append("\n");
            }
        }
        System.out.println(sb);

    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str.equals("***")){
                break;
            }
            sb.append(new StringBuilder(str).reverse()).append("\n");
        }
        System.out.println(sb);

    }
}

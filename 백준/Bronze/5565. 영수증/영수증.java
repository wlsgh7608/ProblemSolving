import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tot = Integer.parseInt(br.readLine( ));

        for(int i = 0 ; i<9;i++){
            tot -= Integer.parseInt(br.readLine());
        }
        System.out.println(tot);
    }
}

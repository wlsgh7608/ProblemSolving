import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int big = Integer.parseInt(br.readLine());
        int small = Integer.parseInt(br.readLine());

        int tot = 8 * big + 3 * small;

        tot -= 28;
        if(tot<0){
            tot = 0;
        }
        System.out.println(tot);

    }
}

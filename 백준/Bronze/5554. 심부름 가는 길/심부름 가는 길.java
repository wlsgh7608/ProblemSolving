import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sec  = 0 ;
        for(int i = 0; i <4;i++){
            sec += Integer.parseInt(br.readLine());
        }

        System.out.println(sec / 60);
        System.out.println(sec % 60);
    }
}

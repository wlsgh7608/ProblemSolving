import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int aLen = br.readLine().length();
        int bLen = br.readLine().length();

        if (aLen < bLen) {
            System.out.println("no");
        }else{
            System.out.println("go");
        }

    }
}

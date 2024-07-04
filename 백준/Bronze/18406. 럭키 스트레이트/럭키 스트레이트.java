import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        String str1 = str.substring(0, N/2);
        String str2 = str.substring(N/2);

        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0 ; i<N/2;i++){
            sum1 += str1.charAt(i);
            sum2 += str2.charAt(i);
        }
        if(sum1==sum2){
            System.out.println("LUCKY");
        }else{
            System.out.println("READY");
        }


    }
}

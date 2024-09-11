import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int len = Integer.toString(N).length();
        int ans = 0;

        for(int i=0;i<len;i++) {
            int digit = N%10;
            N = N/10;

            if(digit>4)
                ans += (digit-1)*Math.pow(9,i);
            else
                ans += digit*Math.pow(9, i);
        }
        System.out.println(ans);

    }
}

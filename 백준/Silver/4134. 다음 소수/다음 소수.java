import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static long findPrimeNum(long n){
        long result = -1;
        if(n<=2){
            return 2;
        }

        for(long i = n; i<=Long.MAX_VALUE;i++){
            boolean isPrime = true;
            for(long j = 2 ; j*j<=i;j++){
                if(i%j==0){
                    isPrime= false;
                    break;
                }
            }
            if(isPrime){
                result = i;
                break;
            }

        }
        return result;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            long N = Long.parseLong(br.readLine());
            sb.append(findPrimeNum(N)).append("\n");
        }
        System.out.println(sb);
    }
}

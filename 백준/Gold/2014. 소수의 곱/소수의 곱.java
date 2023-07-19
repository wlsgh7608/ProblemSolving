import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] primes = new long[K];
        st = new StringTokenizer(br.readLine());

        PriorityQueue<Long> PQ = new PriorityQueue<>();
        for(int i = 0 ; i<K;i++){
            primes[i] = Long.parseLong(st.nextToken());
            PQ.add(primes[i]);
        }

        long lastN = -1;
        while(N-->0){
            lastN = PQ.poll();

            for(long n: primes){
                long newN = lastN*n;

                if(newN >=  (long)1<<31){
                    break;
                }
                PQ.add(newN);
                if(lastN%n==0){
                    break;
                }
            }
        }
        System.out.println(lastN);

    }
}

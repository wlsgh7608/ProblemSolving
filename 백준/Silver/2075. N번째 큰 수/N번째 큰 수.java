import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for(int i=  0; i <N;i++){
            int n = Integer.parseInt(st.nextToken());
            PQ.add(n);
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N;j++){
                int n = Integer.parseInt(st.nextToken());
                if(PQ.peek()<n){
                    PQ.poll();
                    PQ.add(n);
                }
            }
        }

        System.out.println(PQ.peek());
    }
}

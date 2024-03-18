import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        boolean[] isQueue = new boolean[N];
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num==0){
                isQueue[i] = true;
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(isQueue[i]){
                deque.addFirst(num);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            deque.add(num);
            sb.append(deque.poll()).append(" ");
        }
        System.out.println(sb);
    }

}

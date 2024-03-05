import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-->0){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<String, Integer> hm= new HashMap<>();
            for(int i = 0 ; i<N;i++){
                hm.put(st.nextToken(),i);
            }

            st = new StringTokenizer(br.readLine());
            int[] arrIdx = new int[N];
            for(int i = 0 ; i<N;i++){
                arrIdx[i] = hm.get(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            String[] decode = new String[N];
            for(int i= 0 ; i<N;i++){
                decode[arrIdx[i]] = st.nextToken();
            }

            for(String str : decode){
                sb.append(str).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

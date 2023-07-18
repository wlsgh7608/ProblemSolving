import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashSet<Integer> ha = new HashSet<>();
        HashSet<Integer> hb = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i= 0 ; i<A;i++){
            ha.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<B;i++){
            hb.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for(int n : ha){
            if(!hb.contains(n)){
                list.add(n);
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int n : list){
            sb.append(n+" ");
        }
        System.out.println(sb);
    }
}

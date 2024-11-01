import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        HashMap<Integer, List<String>> hm = new HashMap<>();

        for(int i =0 ;  i<N;i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            List<String> orders = hm.getOrDefault(price, new ArrayList<>());
            orders.add(name);
            hm.put(price, orders);
        }


        List<Integer> keys = new ArrayList<>(hm.keySet());

        Collections.sort(keys,(o1,o2)->{
            if (hm.get(o1).size() == hm.get(o2).size()) {
                return o1 - o2;
            }
            return hm.get(o1).size() - hm.get(o2).size();
        });
        int bidN = keys.get(0);
        System.out.println(hm.get(bidN).get(0) + " " + bidN);
    }
}

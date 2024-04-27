import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < L; i++) {
            String stdId = br.readLine();
            hm.put(stdId, i);
        }

        List<String> keySet = new ArrayList<>(hm.keySet());
        keySet.sort((o1, o2) -> hm.get(o1) - hm.get(o2));

        for (int i = 0; i < K && i < keySet.size(); i++) {
            System.out.println(keySet.get(i));
        }


    }
}

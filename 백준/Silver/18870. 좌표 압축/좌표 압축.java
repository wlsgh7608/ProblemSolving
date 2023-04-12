import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            hs.add(arr[i]);
        }

        List<Integer> list = new ArrayList<>(hs);
        Collections.sort(list);
        HashMap<Integer, Integer> hm = new HashMap();
        int idx = 0;
        for (int n : list) {
            hm.put(n, idx++);
        }
        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(hm.get(n) + " ");
        }
        System.out.println(sb);


    }
}

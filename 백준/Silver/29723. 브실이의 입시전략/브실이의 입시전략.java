import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            map.put(name, score);
        }

        int min = 0;
        int max = 0;
        for (int i = 0; i < K; i++) {
            String name = br.readLine();
            min += map.get(name);
            max += map.get(name);
            map.remove(name);
        }
        List<Integer> scores = new ArrayList<>(map.values());
        Collections.sort(scores);
        for (int i = 0; i < M - K; i++) {
            min += scores.get(i);
        }
        for (int i = scores.size() - 1; i >= scores.size() - M + K; i--) {
            max += scores.get(i);
        }
        System.out.println(min + " " + max);


    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> stringHm = new HashMap<>();
        HashMap<Integer, String> intHm = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String poketmon = br.readLine();
            stringHm.put(poketmon, i);
            intHm.put(i, poketmon);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            try {
                int n = Integer.parseInt(input);
                sb.append(intHm.get(n)).append("\n");
            } catch (NumberFormatException e) {
                sb.append(stringHm.get(input)).append("\n");
            }
        }
        System.out.println(sb);


    }
}

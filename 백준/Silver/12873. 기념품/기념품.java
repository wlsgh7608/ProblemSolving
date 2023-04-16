import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cur = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        long step = 1;
        while (list.size() > 1) {
            long cnt = step * step * step;
            int remain = (int) ((cur + cnt - 1) % list.size());
            list.remove(remain);
            step++;
            cur = remain;
        }
        System.out.println(list.get(0));


    }
}

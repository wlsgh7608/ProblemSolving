import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Line {
        int d;
        int l;

        public Line(int d, int l) {
            this.d = d;
            this.l = l;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] length = new int[5];

        List<Line> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            length[d] += l;
            list.add(new Line(d, l));
        }
        int d = length[1];
        int h = length[3];
        list.add(list.get(0));
        list.add(list.get(1));
        list.add(list.get(2));
        int area = d * h;

        for (int i = 0; i < 6; i++) {
            if (list.get(i).d != list.get(i + 2).d) {
                continue;
            }
            if (list.get(i + 1).d != list.get(i + 3).d) {
                continue;
            }
            area -= list.get(i + 1).l * list.get(i + 2).l;
        }
        System.out.println(area * N);


    }
}

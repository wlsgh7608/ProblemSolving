import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Fish {
        int x;
        int y;

        public Fish(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Fish> fishList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            fishList.add(new Fish(x, y));
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int maxL = I / 2;
                for (int k = 1; k < maxL; k++) {
                    int dx = k;
                    int dy = maxL - k;

                    int cnt = 0;

                    for (int p = 0; p < M; p++) {

                        Fish fish_i = fishList.get(i);
                        Fish fish_j = fishList.get(j);
                        Fish cur = fishList.get(p);
                        if (fish_i.x <= cur.x && cur.x <= fish_i.x + dx) {
                            if (fish_j.y <= cur.y && cur.y <= fish_j.y + dy) {
                                cnt++;
                            }
                        }
                    }
                    ans = Math.max(ans, cnt);

                }
            }
        }
        System.out.println(ans);


    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Sticker {
        int r;
        int c;

        public Sticker(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int minSide;
    static int maxSide;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(br.readLine());

        Sticker[] stickers = new Sticker[Q];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            stickers[i] = new Sticker(r, c);
        }

        minSide = Math.min(N, M);
        maxSide = Math.max(N, M);


        int maxArea = 0;

        for (int i = 0; i < Q; i++) {
            for (int j = i + 1; j < Q; j++) {
                int case1 = getArea(stickers[i], stickers[j]);

                maxArea = Math.max(maxArea, case1);
            }
        }
        System.out.println(maxArea);


    }

    private static int getArea(Sticker s1, Sticker s2) {

        int[] side1 = {s1.r, s1.c};
        int[] side2 = {s2.r, s2.c};
        int[] paper = {minSide, maxSide};

        int area = s1.r * s1.c + s2.r * s2.c;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for(int k = 0; k<2;k++){
                    if (side1[i] > paper[k] || side2[j] > paper[k]) {
                        continue;
                    }
                    if (side1[(i+1)%2] + side2[(j+1)%2] > paper[(k+1)%2]) {
                        continue;
                    }
                    return area;
                }
            }
        }
        return 0;


    }
}

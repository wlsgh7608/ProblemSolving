import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Cube implements Comparable<Cube> {
        int l;
        int num;

        public Cube(int l, int num) {
            this.l = l;
            this.num = num;
        }

        @Override
        public int compareTo(Cube o) {
            return o.l - this.l;
        }
    }

    static boolean comb(int l, int w, int h) {
        if (l == 0 || w == 0 || h == 0) {
            return true;
        }

        for (Cube cube : cubes) {
            if (cube.num > 0) {
                int len = cube.l;
                if (l >= len && w >= len && h >= len) {
                    ans++;
                    cube.num--;
                    boolean result = true;
                    result = comb(l - len, w, h);
                    if (!result) {
                        return false;
                    }
                    result = comb(len, w, h - len);
                    if (!result) {
                        return false;
                    }
                    result = comb(len, w - len, len);
                    if (!result) {
                        return false;
                    }
                    return true;
                }
            }

        }
        return false;
    }

    static boolean isTrue = true;
    static Cube[] cubes;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        cubes = new Cube[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            cubes[i] = new Cube((int) Math.pow(2, length), num);
        }
        Arrays.sort(cubes);
        boolean result = comb(l, w, h);
        if (result) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }
}

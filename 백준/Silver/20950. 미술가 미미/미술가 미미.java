import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Paint {
        int r;
        int g;
        int b;

        public Paint(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public int diff(Paint p) {
            return Math.abs(r - p.r) + Math.abs(g - p.g) + Math.abs(b - p.b);
        }
    }

    static Paint gomPaint;
    static int minDiff = Integer.MAX_VALUE;


    static void dfs(int idx, int cnt, int r, int g, int b, Paint[] paints) {
        if (cnt > 7) {
            return;
        }
        if (cnt >= 2) {
            Paint newPaint = new Paint(r / cnt, g / cnt, b / cnt);
            int diff = gomPaint.diff(newPaint);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        if (idx == paints.length) {
            return;
        }
        Paint cur = paints[idx];
        dfs(idx + 1, cnt + 1, r + cur.r, g + cur.g, b + cur.b, paints);
        dfs(idx + 1, cnt, r, g, b, paints);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Paint[] paints = new Paint[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            paints[i] = new Paint(r, g, b);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        gomPaint = new Paint(r, g, b);

        dfs(0, 0, 0, 0, 0, paints);
        System.out.println(minDiff);
    }
}

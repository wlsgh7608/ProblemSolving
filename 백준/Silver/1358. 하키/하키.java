import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isInSquare(int x, int y, int X, int Y, int W, int H) {
        return (X <= x && x <= X + W && Y <= y && y <= Y + H);
    }

    static boolean isInSqure(int x, int y, Point p, int r) {

        int dist = (p.x - x) * (p.x - x) + (p.y - y) * (p.y - y);
        return dist <= r * r;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());


        int result = 0;

        Point p1 = new Point(X, Y + H / 2);
        Point p2 = new Point(X + W, Y + H / 2);
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (isInSqure(x, y, p1, H / 2) || isInSqure(x, y, p2, H / 2) || isInSquare(x, y, X, Y, W, H)) {
                result++;
            }

        }
        System.out.println(result);


    }
}

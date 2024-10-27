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

    static int getDistance(Point p1, Point p2) {
        int xDiff = Math.abs(p1.x - p2.x);
        int yDiff = Math.abs(p1.y - p2.y);
        return xDiff + yDiff;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }
        int sum = 0;
        for (int i = 1; i < N; i++) {
            sum += getDistance(points[i - 1], points[i]);
        }

        int minValue = sum;
        for (int i = 1; i < N - 1; i++) {
            int newDiff = getDistance(points[i - 1], points[i]) + getDistance(points[i], points[i + 1]) - getDistance(points[i - 1], points[i + 1]);
            minValue = Math.min(minValue, sum - newDiff);
        }
        System.out.println(minValue);
    }
}

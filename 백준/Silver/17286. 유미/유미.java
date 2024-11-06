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

        public Point() {
        }
    }

    static double getDist(Point p1, Point p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return Math.pow((dx * dx + dy * dy), 0.5);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Point yumi = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Point[] points = new Point[3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int minDist = Integer.MAX_VALUE;


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < 3; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    double dist = getDist(yumi, points[i]) + getDist(points[i], points[j]) + getDist(points[j], points[k]);
                    minDist = Math.min(minDist, (int) dist);

                }
            }
        }
        System.out.println(minDist);


    }
}

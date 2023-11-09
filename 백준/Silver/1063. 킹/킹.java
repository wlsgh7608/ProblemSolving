import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
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

    static int[] dx;
    static int[] dy;
    static Point A;
    static Point B;

    static boolean isOut(Point p, int d) {
        int nx = p.x + dx[d];
        int ny = p.y + dy[d];

        if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8) {
            return true;
        }
        p.x = nx;
        p.y = ny;
        return false;
    }


    static void simulate(int d) {
        int nx = A.x + dx[d];
        int ny = A.y + dy[d];

        if (nx == B.x && ny == B.y) {
            if (isOut(B, d)) {
                return;
            }
        }
        isOut(A, d);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dx = new int[]{-1, 0, 1, -1, 0, 1, -1, 1};
        dy = new int[]{-1, -1, -1, 1, 1, 1, 0, 0};
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("R", 7);
        hm.put("L", 6);
        hm.put("B", 1);
        hm.put("T", 4);
        hm.put("RT", 5);
        hm.put("LT", 3);
        hm.put("RB", 2);
        hm.put("LB", 0);

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        A = new Point(a.charAt(0) - 'A', a.charAt(1) - '1');
        String b = st.nextToken();
        B = new Point(b.charAt(0) - 'A', b.charAt(1) - '1');
        int iter = Integer.parseInt(st.nextToken());

        while (iter-- > 0) {
            String cmd = br.readLine();
            int d = hm.get(cmd);
            simulate(d);
        }
        String aPoint = "";
        aPoint += (char) ('A' + A.x);
        aPoint += (char) ('1' + A.y);
        String bPoint = "";
        bPoint += (char) ('A' + B.x);
        bPoint += (char) ('1' + B.y);
        System.out.println(aPoint);
        System.out.println(bPoint);


    }
}

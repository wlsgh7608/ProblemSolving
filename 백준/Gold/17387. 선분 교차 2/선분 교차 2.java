import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		long x;
		long y;

		public Point(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		Point p1 = new Point(x1, y1);
		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());
		Point p2 = new Point(x2, y2);

		st = new StringTokenizer(br.readLine());
		long x3 = Long.parseLong(st.nextToken());
		long y3 = Long.parseLong(st.nextToken());
		Point p3 = new Point(x3, y3);
		long x4 = Long.parseLong(st.nextToken());
		long y4 = Long.parseLong(st.nextToken());
		Point p4 = new Point(x4, y4);

		int res1 = getCCW(p1, p2, p3) * getCCW(p1, p2, p4);
		int res2 = getCCW(p3, p4, p1) * getCCW(p3, p4, p2);

		boolean res3 = Math.min(p1.x, p2.x) <= Math.max(p3.x, p4.x) && Math.min(p3.x, p4.x) <= Math.max(p1.x, p2.x);

		boolean res4 = Math.min(p1.y, p2.y) <= Math.max(p3.y, p4.y) && Math.min(p3.y, p4.y) <= Math.max(p1.y, p2.y);

		int ans = 0;

		if (res1 == 0 && res2 == 0) {
			if (res3 && res4) {
				ans = 1;
			} else {
				ans = 0;
			}

		} else if (res1 <=0 && res2 <= 0) {
			ans = 1;
		} else {
			ans = 0;
		}
		System.out.println(ans);

	}

	static int getCCW(Point p1, Point p2, Point p3) {
		long result = ((p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y));
		if (result > 0) {
			return 1;
		} else if (result < 0) {
			return -1;
		} else {
			return 0;
		}
	}

}

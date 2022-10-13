import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Point implements Comparable<Point> {
		long x;
		long y;

		public Point(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.y == o.y) {
				return Long.compare(this.x, o.x);
			}
			return Long.compare(this.y, o.y);
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	static class Vect implements Comparable<Vect> {
		Point p;
		double angle;
		double dist;

		public Vect(Point p, double outer, double dist) {
			super();
			this.p = p;
			this.angle = outer;
			this.dist = dist;
		}

		@Override
		public int compareTo(Vect o) {
			if (this.angle == o.angle) {
				return Double.compare(this.dist, o.dist);
			}
			return -1 * Double.compare(this.angle, o.angle);
		}

		@Override
		public String toString() {
			return "Vect [p=" + p + ", angle=" + angle + ", dist=" + dist + "]";
		}

	}

	static double getDistance(Point a, Point b) {
		long dist = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
		return Math.pow(dist, 0.5);
	}

	static double getAngle(Point a, Point b) {

		return Math.atan2((b.x - a.x), (b.y - a.y));
	}

	static boolean isCCW(Point a, Point b) {

		long result = a.x * b.y - a.y * b.x; // 외적

		if (result > 0) { // 0보다 크면 반시계
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Point> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());
			list.add(new Point(x, y));
		}
		Collections.sort(list);
		Point start = list.remove(0);
		List<Vect> listVect = new ArrayList<>();
		for (Point p : list) {
			double angle = getAngle(start, p);
			double dist = getDistance(start, p);
			listVect.add(new Vect(p, angle, dist));
		}

		Collections.sort(listVect);

		Stack<Point> answer = new Stack<>();
		answer.add(start);
		Point s = listVect.get(0).p;
		answer.add(s);
		for (int i = 1; i < listVect.size(); i++) {
			Point cur = listVect.get(i).p;
			s = answer.peek();
			Point f = answer.get(answer.size() - 2);
			Point curVec = new Point(cur.x - s.x, cur.y - s.y);
			Point lVec = new Point(s.x - f.x, s.y - f.y);
			if (isCCW(lVec, curVec)) {
				answer.add(cur);
			} else {
				answer.pop();
				if (answer.size() >= 2) {
					while (answer.size() >= 2) {

						Point a = answer.get(answer.size() - 2);
						Point b = answer.peek();
						Point c = cur;
						if (isCCW(new Point(b.x - a.x, b.y - a.y), new Point(c.x - b.x, c.y - b.y))) {
							answer.add(cur);
							break;
						}
						answer.pop();
					}

				} else {
					answer.add(cur);
				}
			}
		}
		System.out.println(answer.size());

	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		long x;
		long y;
		
		public Point(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static double getCCW(Point p1, Point p2) {
		double result = (start.x*p1.y+p1.x*p2.y+p2.x*start.y)-(p1.x*start.y+p2.x*p1.y+start.x*p2.y);
		return result/2;
	}
	
	static Point start;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Point[] p = new Point[N+1];
		for(int i = 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());
			p[i] = new Point(x,y);
		}
		start= p[0];
		
		double result = 0.0;
		for(int i = 1; i<N-1;i++) {
			result+= getCCW(p[i],p[i+1]);
		}
		result = 1.0*Math.round(result*100)/100;
		result= Math.abs(result);
		String area = String.format("%.1f", result);
		System.out.println(area);
	}

}

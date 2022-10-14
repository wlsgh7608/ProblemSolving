import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
		
	}
	static int isCCW(Point v1,Point v2) {
		int result = v1.x*v2.y -v1.y*v2.x;
		if(result >0 ) {
			result = 1;
		}else if(result <0) {
			result = -1;
		}
		return result;
		
	}
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Point p1 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine()," ");
		Point p2 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine()," ");
		Point p3 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		
		Point v1 = new Point(p2.x-p1.x,p2.y-p1.y);
		Point v2 = new Point(p3.x-p2.x,p3.y-p2.y);
		System.out.println(isCCW(v1, v2));
		
		
		

	}

}

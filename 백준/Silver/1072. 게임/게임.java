import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static public boolean getPercent(int a) {
		long newY = a+Y;
		long newX = a+X;
		
		long newP = newY*100/newX;
		if(p==newP) {
			return true;
		}else {
			return false;
		}
		
	}
	static long X;
	static long Y;
	static long p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		
		int lo = 1;
		int hi = 1_000_000_000;
		p = 100*Y/X;	
		while(lo<=hi) {
			int m = (lo+hi)/2;
			if(getPercent(m)) {
				lo = m+1;
			}else {
				hi = m-1;
			}
		}
		
		if(lo ==1_000_000_001) {
			lo = -1;
		}
		System.out.println(lo);
		
	}

}

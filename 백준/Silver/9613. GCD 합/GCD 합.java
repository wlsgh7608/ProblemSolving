import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	static int getGCD(int a, int b) {
		
		while(b>0) {
			int temp = a%b;
			a = b;
			b = temp;
		}
		return a;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for(int j = 0; j <n;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			long result = 0;
			
			for(int p = 0; p<n;p++) {
				for(int q = p+1;q<n;q++ ) {
					int a = arr[p];
					int b = arr[q];
					int gcd = getGCD(a, b);
					result+=gcd;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
		
		
		
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken()); 
		int S = Integer.parseInt(st.nextToken()); 
		
		if(S == 1 || T <= 11 || T > 16) {
			System.out.println("280");
		} else if(T >= 12 && T <= 16 && S == 0) {
			System.out.println("320");
		}
	}
	
	
}
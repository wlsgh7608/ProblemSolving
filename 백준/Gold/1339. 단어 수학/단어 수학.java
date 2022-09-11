import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alpha_n = new int[26]; 
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N;i++) {
			String input = br.readLine();
			int len = input.length();
			int digit = 1;
			for(int p = len-1;p>=0;p--) {
				alpha_n[input.charAt(p)-'A'] += digit;
				digit*=10;
			}
			
		}
		Arrays.sort(alpha_n);
		int num = 9;
		int result = 0;
		int p = 25;
		while(num>0 ) {
			result+= num*alpha_n[p];
			p--;
			num--;
		}
		System.out.println(result);
		
	}

}

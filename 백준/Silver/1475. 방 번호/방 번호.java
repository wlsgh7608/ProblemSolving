import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		char[] N = br.readLine().toCharArray();
		int[] cnt = new int[10];
		for(char c: N ) {
			cnt[c-'0']+=1;
		}
		
		int m = (int) Math.ceil(1.0*(cnt[6]+cnt[9])/2);
		cnt[6] = m;
		cnt[9] = m;
		int max = 0;
		for(int n : cnt) {
			max = Math.max(n, max);
		}
		
		System.out.println(max);
	}
}

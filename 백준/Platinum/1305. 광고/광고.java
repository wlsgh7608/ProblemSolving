import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		
		int[] pi = new int[N];
		int j = 0;
		for(int  i = 1;i<N;i++) {
			while(j>0 && input[i]!=input[j]) {
				j = pi[j-1];
			}
			if(input[i] == input[j]) {
				j++;
			}
			pi[i] = j;
		}
		System.out.println(N-pi[N-1]);
		
		
		
	}

}

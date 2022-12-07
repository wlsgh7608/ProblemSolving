import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = line.length();
		HashSet<String> hs = new HashSet<>();
		for(int i = 0; i<N;i++) {
			String cur = "";
			for(int j = i;j<N;j++) {
				cur+= line.charAt(j);
				hs.add(cur);
			}
		}
		System.out.println(hs.size());
		
	}

}

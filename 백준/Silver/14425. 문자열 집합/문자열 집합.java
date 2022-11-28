import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<String> hs = new HashSet<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i = 0; i<N;i++) {
			String str = br.readLine();
			hs.add(str);
		}
		int result = 0;
		for(int i = 0; i<M;i++) {
			String str = br.readLine();
			if(hs.contains(str)) {
				result++;
			}
		}
		System.out.println(result);
	}
}

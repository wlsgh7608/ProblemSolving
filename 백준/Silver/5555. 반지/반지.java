import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String source = br.readLine();
		int N = Integer.parseInt(br.readLine());
		String[] before = new String[N];
		for(int i = 0 ; i<N;i++) {
			before[i] = br.readLine();
		}
		int iter_n = source.length();
		int result = 0;
		for(int i = 0; i<N;i++) {
			String add_target = "";
			for(int j = 0; j <iter_n-1;j++) {
				add_target+=before[i].charAt(j);
			}
			before[i] +=add_target;
			if(before[i].contains(source)) {
				result++;
			}
		}
		System.out.println(result);
		
	}

}

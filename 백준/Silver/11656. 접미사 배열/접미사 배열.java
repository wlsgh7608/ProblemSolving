import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		sb.append(input);
		input = sb.reverse().toString();
		String suf = "";
		
		List<String> result = new ArrayList<>();
		for(int i = 0; i<input.length();i++) {
			suf+=input.charAt(i);
			StringBuilder rev  = new StringBuilder();
			String suffix =rev.append(suf).reverse().toString();
			result.add(suffix);
		}
		Collections.sort(result);
		sb = new StringBuilder();
		for(String str : result) {
			sb.append(str).append("\n");
		}
		System.out.println(sb);
	}

}

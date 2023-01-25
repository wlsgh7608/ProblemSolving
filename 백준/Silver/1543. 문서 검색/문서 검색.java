import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String raw = br.readLine();
		String find = br.readLine();
		
		int rawSize = raw.length();
		int findSize = find.length();
		raw = raw.replace(find, "");
		
		int cnt = (rawSize-raw.length())/findSize;
		
		
		System.out.println(cnt);
		
		
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] input = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		int len = bomb.length;
		Stack<Character> S  = new Stack<>();
		for(char c:input) {
			S.add(c);
			if(S.size()>=len) {
				boolean isBomb = true;
				for(int i = 0;i<len;i++) {
					int last = S.size()-1-i;
					if(S.get(last) !=bomb[len-1-i]) {
						isBomb = false;
						break;
					}
					
				}
				
				if(isBomb) {
					for(int i = 0;i<len;i++) {
						S.pop();
					}
				}
			}
			
		}
		
		if(S.isEmpty()) {
			sb.append("FRULA");
		}
		else {
			for(char c:S) {
				sb.append(c);
			}
			
		}
		System.out.println(sb);
		
	}

}

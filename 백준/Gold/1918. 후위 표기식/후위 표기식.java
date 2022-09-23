import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input =  br.readLine();
		Stack<Integer> CCH = new Stack<>();
		for(int i : CCH) {
			System.out.println(i);
		}
		Stack<Character> S = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<input.length();i++) {
			char c= input.charAt(i);
			
			if(c == '+' || c=='-' ||c== '*' || c=='/') {
				while(!S.isEmpty()&&order(S.peek())>=order(c)) {
					sb.append(S.pop());
				}
				S.add(c);
			}
			else if (c=='(') {
				S.add(c);
			}
			else if( c==')') {
				while(!S.isEmpty() && S.peek()!='(') {
					sb.append(S.pop());
				}
				S.pop();
				
			}else {
				sb.append(c);
			}
			
			
			
		}
		while(!S.isEmpty()) {
			sb.append(S.pop());
		}
		
		System.out.println(sb);

	
	}
	
	
	
	
	
	static int order(char c) {
		if(c=='+'||c=='-') {
			return 2;
		}else if(c == '*' || c=='/') {
			return 3;
		}else if (c== '(' || c== ')') {
			return 1;
		}else {
			return 0;
		}
	}
	
	

}

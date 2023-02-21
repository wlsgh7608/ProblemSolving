import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t= 0 ; t<T;t++) {
			char[] input = br.readLine().toCharArray();
			int N = input.length;
			
			int p = 0;
			List<Character> list = new LinkedList();
			for(char c : input) {
				switch(c) {
				case '<':
					p = Math.max(p-1, 0);
					break;
				case '>':
					p = Math.min(p+1, list.size());
					break;
				case '-':
					if(p == 0) {
						continue;
					}
					list.remove(--p);
					break;
				default:
					if(p==list.size()) {
						list.add(c);
					}else {
						list.add(p,c);
					}
					p++;
				}
			}
			for(char c : list) {
				sb.append(c);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}

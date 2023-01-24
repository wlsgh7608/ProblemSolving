import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static class Serial implements Comparable<Serial>{
		String name;
		int cnt;

		public Serial(String name,int cnt) {
			super();
			this.name = name;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Serial o) {
			if(this.name.length() == o.name.length()) {
				if(this.cnt==o.cnt) {
					return this.name.compareTo(o.name);
				}
				return this.cnt-o.cnt;
			}
			return this.name.length()-o.name.length();
		}
		
		
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Serial> list = new ArrayList<>();
		for(int i = 0; i<N;i++) {
			String name = br.readLine();
			int sum = 0;
			for(char c : name.toCharArray()) {
				if(Character.isDigit(c))
					sum+=c-'0';
				
			}
			list.add(new Serial(name,sum));
		}
		Collections.sort(list);
		
		StringBuilder sb =  new StringBuilder();
		for(Serial s : list) {
			sb.append(s.name).append("\n");
		}
		System.out.println(sb);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int c = 0; c < T; c++) {
			Deque<Integer> deque = new ArrayDeque<>() ;
			String cmds = br.readLine();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(),"\\[|\\]|\\,");
			while(st.hasMoreTokens()) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean isWorking = true;
			boolean isFront = true;
			
			for(int i =0; i<cmds.length();i++) {
				char cmd = cmds.charAt(i);
				if (cmd =='R') {
					isFront = !isFront;
				}else {
					if(deque.isEmpty()) {
						isWorking = false;
						sb.append("error").append("\n");
						break;
					}
					if(isFront) {
						deque.pollFirst();
					}else {
						deque.pollLast();
					}
					
				}
				
			}
			if(isWorking) {
				sb.append("[");
				while(!deque.isEmpty()) {
					int cur;
					if(isFront) {
						cur = deque.pollFirst();
					}
					else {
						cur = deque.pollLast();
					}
					sb.append(cur);
					if(deque.isEmpty()) {
						break;
					}
					sb.append(",");
					
				}
				sb.append("]");
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}

}





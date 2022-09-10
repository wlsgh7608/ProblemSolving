import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static List<Integer> preorders;
	
	static void preToPost(int start,int end) {
		if(start<=end) {
			int rightIdx = end+1;
			for(int i = start+1;i<end+1;i++) {
				if(preorders.get(i)>preorders.get(start)) {
					rightIdx = i;
					break;
				}
			}
			preToPost(start+1,rightIdx-1);
			preToPost(rightIdx,end);
			sb.append(preorders.get(start)).append("\n");
			
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		preorders = new ArrayList<>();
		
		while(true) {
			String input = br.readLine();
			if(input ==null || input.equals("")) {
				break;
			}
			
			int n = Integer.parseInt(input);
			preorders.add(n);
		}
		preToPost(0,preorders.size()-1);
		System.out.println(sb);
		
		
		
	}

}




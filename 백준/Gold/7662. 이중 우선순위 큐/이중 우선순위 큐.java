import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T;t++) {
        	int N = Integer.parseInt(br.readLine());
        	TreeMap<Integer, Integer> tm = new TreeMap<>();
        	for(int i = 0; i<N;i++) {
        		StringTokenizer  st = new StringTokenizer(br.readLine()," ");
        		char a = st.nextToken().charAt(0);
        		int num = Integer.parseInt(st.nextToken());
        		if(a=='I') {
        			tm.put(num, tm.getOrDefault(num,0)+1);
        		}else {
        			if(!tm.isEmpty()) {
        				if(num == 1) {
        					tm.put(tm.lastKey(),tm.get(tm.lastKey())-1);
        					if(tm.get(tm.lastKey())==0) {
        						tm.remove(tm.lastKey());
        					}
        				}else {
        					tm.put(tm.firstKey(),tm.get(tm.firstKey())-1);
        					if(tm.get(tm.firstKey())==0) {
        						tm.remove(tm.firstKey());
        					}
        				}
        			}
        		}
        		
        	}
        	if(tm.isEmpty()) {
        		sb.append("EMPTY").append("\n");
        	}
        	else {
        		sb.append(tm.lastKey()+" "+tm.firstKey()).append("\n");
        	}
        }
        System.out.println(sb);
        
    }
}

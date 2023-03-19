import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {
	
	static void perm(int depth ,int flag,long n) {
		hs.add(n);
		if(depth==12) {
			return;
		}
		for(int i = 0 ; i<10;i++) {
			if((flag&1<<i)==0) {
				if(depth==0) {
					long newN = n;
					newN+=i*Math.pow(10, depth);
					perm(depth+1,flag|1<<i,newN);
				}else {
					long prev = n;
					prev = prev%10;
					if(i<prev) {
						long newN = 10*n + i;
						perm(depth+1,flag|1<<i,newN);
					}
				}
			}
		}
	}

	static HashSet<Long> hs;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		hs = new HashSet<>();
		perm(0,0,0);
		List<Long> list = new ArrayList<>(hs);
		Collections.sort(list);
		if(N>=list.size()) {
			System.out.println(-1);
		}else {
			System.out.println(list.get(N));
		}
		
	}

}

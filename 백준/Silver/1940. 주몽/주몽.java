import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int [N];
		StringTokenizer st  = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int p = 0;
		int q = N-1;
		int cnt = 0;
		while(p<q){
			int sum = arr[p]+arr[q];
			if(sum>M) {
				q--;
			}else if (sum < M) {
				p++;
			}else {
				cnt++;
				p++;
				q--;
			}
			
		}
		System.out.println(cnt);
		
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int i = N-1;
		while(i>0 && arr[i-1]>=arr[i]) {
			i--;
		}
		
		if(i==0) {
			System.out.println(-1);
		}else {
			int j = N-1;
			while(arr[i-1]>=arr[j]) {
				j--;
			}
			
			int temp = arr[i-1];
			arr[i-1] = arr[j];
			arr[j] = temp;
			int k = N-1;
			while(i<k) {
				int tmp = arr[i];
				arr[i] = arr[k];
				arr[k] = tmp;
				i++;
				k--;
			}
			StringBuilder sb = new StringBuilder();
			for(int n : arr) {
				sb.append(n+" ");
			}
			System.out.println(sb);
		}
		
		
		
	}

}

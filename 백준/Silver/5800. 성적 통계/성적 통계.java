import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[M];
			for (int j = 0; j < M; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			int gap = 0;
			for(int j = 1;j<M;j++) {
				gap = Math.max(gap, arr[j]-arr[j-1]);
			}
			int max = arr[M-1];
			int min = arr[0];
			
			sb.append("Class "+i).append("\n");
			sb.append("Max "+max+", Min "+min+", Largest gap "+gap).append("\n");
		}
		System.out.println(sb);
	}
}

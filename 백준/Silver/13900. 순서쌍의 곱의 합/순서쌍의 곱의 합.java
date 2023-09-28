import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long[] num = new Long[N + 1];
		Long[] cumSum = new Long[N + 1];
		num[0] = 0L;
		cumSum[0] = 0L;
		for (int i = 1; i <= N; i++) {
			num[i] = Long.parseLong(st.nextToken());
			cumSum[i] = num[i] + cumSum[i - 1];
		}
		Long sumVal = 0L;
		for (int i = 2; i <= N; i++) {
			sumVal += num[i] * cumSum[i-1];
		}
		System.out.println(sumVal);

	}
}
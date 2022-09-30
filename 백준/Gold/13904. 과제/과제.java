import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Hw implements Comparable<Hw> {
		int day;
		int cost;

		public Hw(int day, int cost) {
			super();
			this.day = day;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Hw [day=" + day + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Hw o) {
			return o.day - this.day;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Hw[] arr = new Hw[N];
		boolean[] isUses = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new Hw(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		int curDay = arr[0].day;
		int result = 0;
		for (int i = curDay; i > 0; i--) {
			int max_idx = -1;
			int max_c = 0;
			for (int j = 0; j < N; j++) {
				if (!isUses[j] &&arr[j].day>=i && arr[j].cost>max_c) {
					max_idx = j;
					max_c = arr[j].cost;
				}
			}
			if(max_idx!=-1) {
				isUses[max_idx] = true;
				result+=arr[max_idx].cost;
			}
		}
		System.out.println(result);

	}

}

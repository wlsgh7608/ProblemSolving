import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class University {
        String name;
        University next;
        University last;

        public University(String name) {
            this.name = name;
            this.next = null;
            this.last = this;
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        University[] arr = new University[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new University(br.readLine());
        }

        University last = null;
        for (int j = 0; j < N - 1; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].last.next = arr[b];
            arr[a].last = arr[b].last;
            last = arr[a];
        }
        StringBuilder sb = new StringBuilder();
        while (last != null) {
            sb.append(last.name);
            last = last.next;
        }
        System.out.println(sb);


    }
}

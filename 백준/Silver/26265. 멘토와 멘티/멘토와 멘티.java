import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Mentoring implements Comparable<Mentoring>{
        String mentor;
        String mentee;

        public Mentoring(String mentor, String mentee) {
            this.mentor = mentor;
            this.mentee = mentee;
        }

        @Override
        public int compareTo(Mentoring o) {
            if (mentor.equals(o.mentor)) {
                return -1 * mentee.compareTo(o.mentee);
            }
            return mentor.compareTo(o.mentor);

        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Mentoring[] arr = new Mentoring[N];
        for(int i  =0 ; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String mentor = st.nextToken();
            String mentee = st.nextToken();
            arr[i] = new Mentoring(mentor, mentee);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<N;i++){
            sb.append(arr[i].mentor + " " + arr[i].mentee).append("\n");
        }
        System.out.println(sb);


    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {


    static class Student implements Comparable<Student>{
        String name;
        int count;

        public Student(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Student o) {
            if(o.count==this.count){
                return this.name.compareTo(o.name);
            }
            return o.count-this.count;
        }
    }

    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N;i++){
            hm.put(st.nextToken(), 0);
        }


        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                String key = st.nextToken();
                hm.put(key, hm.get(key) + 1);
            }
        }
        Student[] students = new Student[N];

        int i = 0;
        for(String key : hm.keySet()){
            students[i] = new Student(key, hm.get(key));
            i++;
        }
        Arrays.sort(students);

        StringBuilder sb = new StringBuilder();
        for(Student s : students){
            sb.append(s.name + " " + s.count).append("\n");
        }
        System.out.println(sb);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Student implements Comparable<Student>{
		String name;
		int m;
		int d;
		int y;
		
		public Student(String name, int m, int d, int y) {
			super();
			this.name = name;
			this.m = m;
			this.d = d;
			this.y = y;
		}
		
		@Override
		public int compareTo(Student o) {
			if(this.y==o.y) {
				if(this.m ==o.m) {
					return this.d-o.d;
				}
				return this.m-o.m;
			}
			
			return this.y-o.y;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", m=" + m + ", d=" + d + ", y=" + y + "]";
		}
		
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Student[] students = new Student[N];
		for(int i = 0; i<N;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int d = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			students[i] = new Student(name, m, d, y);
		}
		Arrays.sort(students);
		System.out.println(students[N-1].name);
		System.out.println(students[0].name);
		
		
		
	}

}

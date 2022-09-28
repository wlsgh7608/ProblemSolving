import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		HashSet<Integer> setA = new HashSet<>();
		HashSet<Integer> setB = new HashSet<>();
		
		
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<A;i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<B;i++) {
			setB.add(Integer.parseInt(st.nextToken()));
		}
		int result = setA.size()+setB.size();
		setA.retainAll(setB);
		int com = setA.size()*2;
		result= result - com;
		System.out.println(result);
		
		
		
		
		

	}

}

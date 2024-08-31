import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double d1 = Double.parseDouble(br.readLine());
		double d2 = Double.parseDouble(br.readLine());
		
		double result = (2 * d1) + (2 * d2 * Math.floor(Math.PI*1000000)/1000000.0);
		
		System.out.println(result);
	}

}
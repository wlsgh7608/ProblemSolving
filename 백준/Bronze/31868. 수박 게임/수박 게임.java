import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i = 0; i < n - 1; i++) {
			k /= 2;
		}
		System.out.println(k);
		sc.close();
	}
}
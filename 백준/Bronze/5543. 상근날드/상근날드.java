import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] hamburger = new int[3];
        int[] drink = new int[2];
        int result = 0;
        int minPrice = 2000;
        for(int i = 0 ;i <3;i++){
            hamburger[i] = Integer.parseInt(br.readLine());
            minPrice = Math.min(minPrice,hamburger[i]);
        }
        result+= minPrice;
        minPrice = 2000;
        for(int i = 0 ; i<2;i++){
            drink[i] = Integer.parseInt(br.readLine());
            minPrice = Math.min(minPrice,drink[i]);
        }
        result+= minPrice - 50;

 
        System.out.print(result);
    }
}
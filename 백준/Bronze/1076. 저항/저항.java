import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("black", 0);
        hm.put("brown", 1);
        hm.put("red", 2);
        hm.put("orange", 3);
        hm.put("yellow", 4);
        hm.put("green", 5);
        hm.put("blue", 6);
        hm.put("violet", 7);
        hm.put("grey", 8);
        hm.put("white", 9);

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();


        int A = hm.get(a);
        int B = hm.get(b);
        int value = 10 * A + B;
        long iter = (long) Math.pow(10,hm.get(c));

        long result = 1L* value*iter;
        System.out.println(result);


    }
}

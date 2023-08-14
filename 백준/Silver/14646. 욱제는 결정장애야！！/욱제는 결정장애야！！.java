import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> hs = new HashSet<>();
        int size = 0;
        int maxSize = 0;
        for(int i = 0; i<2*N;i++){
            int n = Integer.parseInt(st.nextToken());
            if(hs.contains(n)){
                hs.remove(n);
                size--;
            }else{
                hs.add(n);
                size++;
            }
            maxSize = Math.max(maxSize, size);
        }
        System.out.println(maxSize);
    }
}

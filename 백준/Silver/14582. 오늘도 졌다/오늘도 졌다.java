import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arrA = new int[9];
        int[] arrB = new int[9];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;  i<9;i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<9;i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int olim = 0;
        int starlink  = 0;

        String result = "No";
        for(int i = 0 ; i<9;i++){
            olim+=arrA[i];
            if(olim>starlink){
                result = "Yes";
            }
            starlink+=arrB[i];
        }
        System.out.println(result);
    }
}

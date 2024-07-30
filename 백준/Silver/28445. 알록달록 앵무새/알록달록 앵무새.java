import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] mom = new String[2];
        String[] fa = new String[2];
        HashSet<String> colors = new HashSet<>();
        for(int i = 0; i < 2; i++){
            mom[i] = st.nextToken();
            colors.add(mom[i]);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2; i++){
            fa[i] = st.nextToken();
            colors.add(fa[i]);
        }


        List<String> colorList = new ArrayList<>(colors);
        Collections.sort(colorList);

        StringBuilder sb = new StringBuilder();
        for(String color1 : colorList){
            for(String color2 : colorList){
                sb.append(color1 + " " + color2 + "\n");
            }
        }
        System.out.println(sb);



    }
}

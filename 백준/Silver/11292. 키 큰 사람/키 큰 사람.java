import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            int input = Integer.parseInt(br.readLine());
            if(input==0){
                break;
            }

            double maxHeight = 0;
            List<String> list = new ArrayList<>();
            for(int i = 0 ;i <input;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                double height = Double.parseDouble(st.nextToken());
                if(maxHeight<height){
                    maxHeight = height;
                    list = new ArrayList<>();
                    list.add(name);
                }else if(maxHeight == height){
                    list.add(name);
                }
            }

            for(String name : list){
                sb.append(name + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

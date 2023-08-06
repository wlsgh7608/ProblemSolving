import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> toGroup = new HashMap<>();
        HashMap<String, List<String>> toMember = new HashMap<>();


        for(int i = 0 ;i<N;i++){
            String groupName = br.readLine();
            List<String> members = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            for(int j = 0; j<n;j++){
                String name = br.readLine();
                toGroup.put(name, groupName);
                members.add(name);
            }
            Collections.sort(members);
            toMember.put(groupName, members);
        }


        StringBuilder sb = new StringBuilder();
        for(int j = 0 ; j<M;j++){
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if(type==0){
                List<String> members = toMember.get(name);
                for(String member : members){
                    sb.append(member).append("\n");
                }
            }else{
                String group = toGroup.get(name);
                sb.append(group).append("\n");
            }
        }
        System.out.println(sb);
    }
}

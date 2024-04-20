import java.util.*;
class Solution {
    public String[] solution(String[] records) {

        HashMap<String,String> map = new HashMap<>();

        for(String record : records){
            StringTokenizer st = new StringTokenizer(record);
            String command = st.nextToken();
            String id = st.nextToken();

            if(command.equals("Enter") || command.equals("Change")){
                String name = st.nextToken();
                map.put(id, name);
            }

        }
        List<String> result = new ArrayList<>();
        for(String record : records){
            StringTokenizer st = new StringTokenizer(record);
            String command = st.nextToken();
            String id = st.nextToken();

            if(command.equals("Enter")){
                result.add(map.get(id) + "님이 들어왔습니다.");
            }else if(command.equals("Leave")){
                result.add(map.get(id) + "님이 나갔습니다.");
            }
        }


        return result.toArray(new String[0]);
    }
}
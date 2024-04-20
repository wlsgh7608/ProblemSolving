import java.util.*;
class Solution {
    public String[] solution(String[] records) {

        HashMap<String,String> map = new HashMap<>();
        
        // map에 id와 nickname 저장
        for(String record : records){
            StringTokenizer st = new StringTokenizer(record);
            String command = st.nextToken();
            String id = st.nextToken();

            if(command.equals("Enter") || command.equals("Change")){
                String nickname = st.nextToken();
                map.put(id, nickname);
            }

        }
        
        // 채팅방 출력하기
        List<String> result = new ArrayList<>();
        for(String record : records){
            StringTokenizer st = new StringTokenizer(record);
            String command = st.nextToken();
            String id = st.nextToken();
            String nickname = map.get(id);

            if(command.equals("Enter")){
                result.add(nickname + "님이 들어왔습니다.");
            }else if(command.equals("Leave")){
                result.add(nickname + "님이 나갔습니다.");
            }
        }
    
        // list -> arr
        return result.toArray(String[]::new);
    }
}
class Solution {
    
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] skillOrder = new int[26];


        // 스킬트리 순서를 저장
        // ex) "CBD" => C:1, B:2, D:3
        for (int i = 0; i < skill.length(); i++) {
            int idx = skill.charAt(i) - 'A';
            skillOrder[idx] = i + 1;
        }

        fail:
        for (String skill_tree : skill_trees) {
            int skillDepth = 1;
            int skillLen = skill_tree.length();
            for (int i = 0; i < skillLen; i++) {
                int idx = skill_tree.charAt(i) - 'A';

                // 선행조건에 없는 스킬은 무시
                // 선행조건에 있는 스킬이 순서에 맞지 않으면 실패
                if (skillOrder[idx] == skillDepth) {
                    skillDepth++;
                } else if (skillOrder[idx] > skillDepth) {
                    continue fail;
                }
            }
            // 주어진 스킬트리가 선행조건에 만족하면  성공
            answer++;
        }
        return answer;
    }
}
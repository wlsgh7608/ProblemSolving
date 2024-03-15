class Solution {
    static final int ALPHABET = 26;

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        int[] in = new int[ALPHABET];

        for (int i = 0; i < skill.length(); i++) {
            in[skill.charAt(i) - 'A'] = i + 1;
        }


        fail:
        for (String skill_tree : skill_trees) {
            int skillDepth = 1;
            int skillLen = skill_tree.length();
            for (int i = 0; i < skillLen; i++) {
                int idx = skill_tree.charAt(i) - 'A';
                if (in[idx] == skillDepth) {
                    skillDepth++;
                } else if (in[idx] > skillDepth) {
                    continue fail;
                }
            }
            answer++;
        }
        return answer;
    }
}
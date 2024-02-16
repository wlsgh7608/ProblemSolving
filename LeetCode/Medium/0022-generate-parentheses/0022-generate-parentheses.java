import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {

        // n개의 괄호 리스트 출력하기

        // 1 : ()
        // 2 : ()(), (())
        // 3 : ((())), ()

        HashSet<String>[] parenthesis = new HashSet[9];
        for (int i = 0; i <= 8; i++) {
            parenthesis[i] = new HashSet<>();
        }
        parenthesis[1].add("()");
        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (String a : parenthesis[j]) {
                    for (String b : parenthesis[i - j]) {
                        parenthesis[i].add(a + b);
                    }
                }
            }
            for(String a : parenthesis[i-1]){
                parenthesis[i].add("("+a+")");
            }

        }

        return new ArrayList<>(parenthesis[n]);

    }
}
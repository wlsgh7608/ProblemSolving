import java.util.*;

class Solution {
    static final int ALPHA_SIZE = 26;
    static class Trie{
        Trie[] child = new Trie[ALPHA_SIZE];
        int cnt = 0;
        
        void insert(String name){
            Trie cur = this;
            for(int i = 0; i <name.length();i++){
                int idx = name.charAt(i)-'a';
                if(cur.child[idx]==null){
                    cur.child[idx]= new Trie();
                }
                cur.child[idx].cnt +=1;
                cur = cur.child[idx];
            }
        }
        
        int find(String name, int depth){
            if(depth==name.length()){
                return 0;
            }
            int idx = name.charAt(depth)-'a';
            if(this.child[idx].cnt ==1){
                return 1;
            }else{
                return 1 + this.child[idx].find(name,depth+1);
            }
            
            
        }
    }
    public int solution(String[] words) {
        int answer = 0;
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }
        
        for(String word : words){
            int cnt = trie.find(word,0);
            answer += cnt;
        }
        System.out.println(Arrays.toString(trie.child));
        
        return answer;
    }
}
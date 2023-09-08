class Solution {
    
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> answer = new HashSet<>();
        HashSet<String> hs = new HashSet<>();
        
        for(String word : wordDict){
            hs.add(word);
            if(word.length()==s.length()){
                answer.add(word);
            }
        }
        
        while(hs.size()!=0){
            HashSet<String> newHs = new HashSet<>();
            for(String word: wordDict){
                for(String str : hs){
                    String word1 = word+str;
                    String word2 = str+word;
                    int size = word1.length();
                    if(size<s.length()){
                        if(s.substring(0,size).equals(word1)){
                            newHs.add(word1);
                        }else if(s.substring(0,size).equals(word2)){
                            newHs.add(word2);
                        }
                    }else if(size==s.length()){
                        answer.add(word1);
                        answer.add(word2);
                    }
                }
            } 
            hs = newHs;
        }
        if(answer.contains(s)){
            return true;
        }else{
            return false;
        }
    }
}
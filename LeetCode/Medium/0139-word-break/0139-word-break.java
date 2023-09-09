class Solution {
    
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> hs = new HashSet<>();
        
        for(String word : wordDict){
            hs.add(word);
            if(s.equals(word)){
                return true;
            }
        }
        
        String[] sArr = new String[s.length()];
        for(int i = 1; i<s.length();i++){
            sArr[i] = s.substring(0,i);
        }
        
        while(hs.size()!=0){
            HashSet<String> newHs = new HashSet<>();
            for(String word: wordDict){
                for(String str : hs){
                    String word1 = str+word;
                    int size = word1.length();
                    if(size<s.length()){
                        if(sArr[size].equals(word1)){
                            newHs.add(word1);
                        }
                    }else if(size==s.length()){
                        if(s.equals(word1)){
                            return true;
                        }
                        
                    }
                }
            } 
            hs = newHs;
        }
        return false;
    }
}
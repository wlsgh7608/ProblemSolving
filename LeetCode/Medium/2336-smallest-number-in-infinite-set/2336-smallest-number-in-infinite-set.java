class SmallestInfiniteSet {
    
    PriorityQueue<Integer> PQ ;
    HashSet<Integer> hs;

    public SmallestInfiniteSet() {
        PQ = new PriorityQueue<>();
        hs = new HashSet<>();
        for(int i = 1; i<=1000;i++){
            PQ.add(i);
            hs.add(i);
        }
    }
    
    public int popSmallest() {
        int result = PQ.poll();
        hs.remove(result);
        
        return result;
        
    }
    
    public void addBack(int num) {
        if(!hs.contains(num)){
            hs.add(num);
            PQ.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
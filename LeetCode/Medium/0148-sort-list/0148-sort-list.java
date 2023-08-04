/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    
    public ListNode sortList(ListNode head) {  
        ListNode cur = head;
        
        
        List<Integer> list = new ArrayList<>();
        
        while(cur!=null){
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(list);
        Queue<Integer> Q = new ArrayDeque<>();
        for(int n : list){
            Q.add(n);
        }
        
        int p = 0;
        cur = head;
        while(cur!=null){
            cur.val = Q.poll();
            cur = cur.next;
        }
        
        
        return head;
        
    }
}
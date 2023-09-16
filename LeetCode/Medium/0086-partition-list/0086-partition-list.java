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
    public ListNode partition(ListNode head, int x) {
        
        
        if(head== null || head.next==null){
            return head;
        }
        
        ListNode cur = head;
        ListNode small = null;
        ListNode small_last = null;
        ListNode big = null;
        ListNode big_last = null;
        
        
        while(cur!=null){
            ListNode newNode = new ListNode(cur.val);
            if(cur.val >= x){
                if(big==null){
                    big = newNode;
                    big_last = newNode;
                }else{
                    big_last.next = newNode;
                    big_last = newNode;
                }
            }else{
                if(small==null){
                    small= newNode;
                    small_last = newNode;
                }else{
                    small_last.next = newNode;
                    small_last = newNode;
                }
            }
            cur = cur.next;
        }
        
        if(small_last==null){
            return big;
        }
        
        small_last.next = big;
        
    
    
        
       
        return small;
        
    }
}
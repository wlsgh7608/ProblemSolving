/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        // 해당 노드를 삭제하는 것이 아니라
        // 다음 노드의 값들을 가져옴
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
   
        
    }
    
    
}
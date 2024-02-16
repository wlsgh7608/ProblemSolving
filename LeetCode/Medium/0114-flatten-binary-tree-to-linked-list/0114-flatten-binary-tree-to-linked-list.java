/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    void preOrder(TreeNode cur,Stack<TreeNode> S){
        if(cur==null){
            return;
        }
        S.add(cur);
        preOrder(cur.left,S);
        preOrder(cur.right,S);
        
    }
    public void flatten(TreeNode root) {
        Stack<TreeNode> S= new Stack<>();
        preOrder(root,S);
        
        TreeNode prev = null;
        while(!S.isEmpty()){
            TreeNode cur = S.pop();
            cur.left = null;
            cur.right = prev;
            prev = cur;
        }
        
    }
}
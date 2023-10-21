import java.util.*;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> Q = new ArrayDeque<>();
        boolean isRightDirect = true;
        
        if(root!=null){
            Q.add(root);
        }
        

        while (!Q.isEmpty()) {

            Deque<Integer> levelNum = new ArrayDeque<>();
            
            int size = Q.size();

            while(size-->0){
                TreeNode cur = Q.poll();
                levelNum.add(cur.val);
                if(cur.left!=null){
                    Q.add(cur.left);
                }
                if(cur.right!=null){
                    Q.add(cur.right);
                }
            }
            List<Integer> line = new ArrayList<>();
            if(isRightDirect){
                while(!levelNum.isEmpty()){
                    line.add(levelNum.pollFirst());
                }
            }else{
                while(!levelNum.isEmpty()){
                    line.add(levelNum.pollLast());
                }
            }
            isRightDirect = !isRightDirect;
            result.add(line);
        }
        return result;
    }
}
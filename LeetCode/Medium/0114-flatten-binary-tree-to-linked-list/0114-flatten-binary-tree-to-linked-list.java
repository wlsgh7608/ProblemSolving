
class Solution {

    void preOrder(TreeNode cur, Stack<TreeNode> S) {
        if (cur == null) {
            return;
        }
        S.add(cur);
        preOrder(cur.left, S);
        preOrder(cur.right, S);

    }

    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;

    }
}
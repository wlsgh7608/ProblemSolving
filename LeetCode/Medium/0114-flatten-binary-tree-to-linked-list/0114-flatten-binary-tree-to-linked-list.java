class Solution {
    void preOrder(TreeNode cur,List<TreeNode> list){
        if(cur==null){
            return;
        }
        list.add(cur);
        preOrder(cur.left,list);
        preOrder(cur.right,list);
        
    }
    public void flatten(TreeNode root) {
        List<TreeNode> list= new ArrayList<>();
        preOrder(root,list);
        
        TreeNode prev = null;
        for(TreeNode cur : list){
            cur.left = null;
            cur.right = null;
            if(prev!=null){
                prev.right = cur;       
            }
            prev = cur;
        }
        
    }
}
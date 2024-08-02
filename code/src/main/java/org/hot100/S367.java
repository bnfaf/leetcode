package org.hot100;

public class S367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null ){
            return true;
        }
        if (root == null){
            return false;
        }
        if (head.val == root.val && dfs(head, root)){
                return true;
        }
        return isSubPath(head, root.left) | isSubPath(head, root.right);
    }
    public boolean dfs(ListNode head, TreeNode root){
        if(head == null ){
            return true;
        }
        if (root == null){
            return false;
        }
        if (head.val == root.val){
            return dfs(head.next, root.left) | dfs(head.next, root.right);
        }else{
            return false;
        }
    }
}

/*
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
 

Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.

*/

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t==null) {
            return true;
        }
        
        return checkSubTree(s, t);
    }
    
    boolean checkSubTree(TreeNode s, TreeNode t) {
        if(s==null) {
            return false;
        } else if(s.val==t.val && matchTree(s, t)) {
            return true;
        }
        
        return checkSubTree(s.left, t) || checkSubTree(s.right, t);   
    }
    
    boolean matchTree(TreeNode s, TreeNode t) {
        if(s==null && t==null) {
            return true;
        } else if(s==null || t==null) {
            return false;
        } else if(s.val != t.val) {
            return false;
        }
        
        return matchTree(s.left, t.left) && matchTree(s.right, t.right);
    }
}
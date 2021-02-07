/*

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the 
lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    Output: 6
    Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
    Output: 2
    Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example 3:
    Input: root = [2,1], p = 2, q = 1
    Output: 2
 
Constraints:
    The number of nodes in the tree is in the range [2, 105].
    -10^9 <= Node.val <= 10^9
    All Node.val are unique.
    p != q
    p and q will exist in the BST.

*/


//Method 1: If p and q will exist in the tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return commonAnc(root, p, q);
    }
    
    
    
    TreeNode commonAnc(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
            return null;
        } 
        
        if(root==p && root==q) {
            return root;
        }
        
        TreeNode x = commonAnc(root.left, p, q);
        if(x != null && x != p && x != q) {
            return x;
        }
        
        TreeNode y = commonAnc(root.right, p, q);
        if(y != null && y != p && y != q) {
            return y;
        }
        
        if(x != null && y!=null) {
            return root;
        } else if(root==p || root==q) {
            return root;
        } else {
            return x == null ? y : x;
        }
    }
}






//Method 2: If p or q will exist in the tree is not given.

class Result {
    public TreeNode node;
    public boolean isAncestor;
    public Result(TreeNode n, boolean isAnc) {
        node = n;
        isAncestor = isAnc;
    }
} 

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result r = commonAnc(root, p, q);
        if(r.isAncestor) {
            return r.node;
        } 
        
        return null;
    }
    
    Result commonAnc(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return new Result(null, false);
        }
        
        if(root==p && root==q) {
            return new Result(root, true);
        }
        
        Result rx = commonAnc(root.left, p, q);
        if(rx.isAncestor) {
            return rx;
        }
        
        Result ry = commonAnc(root.right, p, q);
        if(ry.isAncestor) {
            return ry;
        }
        
        
        if(rx.node!=null && ry.node!=null) {
            return new Result(root, true);
        } else if(root==p || root==q) {
            boolean isAnc = rx.node!=null || ry.node!=null;
            return new Result(root, isAnc);
        } else {
            return new Result(rx.node!=null ? rx.node : ry.node, false);
        }
    }
    
}
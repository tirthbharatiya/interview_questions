/*

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
    Input: root = [1,2,3,4], x = 4, y = 3
    Output: false

Example 2:
    Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
    Output: true

Example 3:
    Input: root = [1,2,3,null,4], x = 2, y = 3
    Output: false
 
Constraints:
    The number of nodes in the tree will be between 2 and 100.
    Each node has a unique integer value from 1 to 100.

*/

class Solution {
    int[] parents = new int[2];
    int[] depths = new int[2];
    boolean first = false;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        depth(root, x, 0);
        depth(root, y, 0);
        
        if(depths[0]==depths[1] && parents[0]!=parents[1]) {
            return true;
        }
        
        return false;
    }
    
    void depth(TreeNode root, int x, int d) {
        if(root==null) {
            return;
        }
        
        if((root.left!=null && root.left.val==x) || (root.right!=null && root.right.val==x)) {
            if(!first) {
                parents[0] = root.val;
                depths[0] = d+1;
                first = true;
            } else {
                parents[1] = root.val;
                depths[1] = d+1;
            }
            
            return;
        }
        
        if(root.left!=null) {
            depth(root.left, x, d+1);            
        }
        
        if(root.right!=null) {
            depth(root.right, x, d+1);            
        }
        
        
        
    }
}
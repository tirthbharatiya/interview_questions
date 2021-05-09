/*

We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.

Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.

Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).

Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.

Example 1:
Input: [2,1,5]
Output: [5,5,0]

Example 2:
Input: [2,7,4,3,5]
Output: [7,0,5,5,0]

Example 3:
Input: [1,7,5,1,9,2,5,1]
Output: [7,9,9,9,0,5,0,0]
 
Note:
1 <= node.val <= 10^9 for each node in the linked list.
The given list has length in the range [0, 10000].

*/




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
    public int[] nextLargerNodes(ListNode head) {
        int[] arr = toArray(head);
        return nextLargerNodes(arr);
    }
    
    int[] nextLargerNodes(int[] arr) {
        int len = arr.length;
        if(len == 0) {
            return arr;
        }
        if(len == 1) {
            return new int[]{0};
        }
        
        int[] result = new int[arr.length];
        Stack<Integer> st = new Stack();
        
        for(int i=0; i<arr.length-1; i++) {
            int j = i+1;
            if(arr[i] < arr[j]) {
               result[i] = arr[j];
            
                while(!st.empty()) {
                    int idx = st.peek();
                    if(arr[idx] < arr[j]) {
                        result[idx] = arr[j];
                        st.pop();
                    } else {
                        break;
                    }
                    
                }
           } else {
               st.push(i);
           }
        }
        return result;
    }
    
    int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList();
        
        ListNode curr = head;
        
        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }
        
        return getArray(list);
    }
    
    int[] getArray(List<Integer> list) {
        int[] arr = new int[list.size()];
            
        for(int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);    
        }
        
        return arr;
    }
}
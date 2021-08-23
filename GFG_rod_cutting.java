/*

Given a rod of length N inches and an array of prices, price[] that contains prices of all pieces of size smaller than N. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Example 1:
  Input:
    N = 8
    Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
  Output:
    22
  Explanation:
    The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5+17=22.

Example 2:
  Input:
  N=8
  Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
  Output: 24
  Explanation: 
  The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*3=24. 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function cutRod() which takes the array A[] and its size N as inputs and returns the maximum price obtainable.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 1000
1 ≤ Ai ≤ 10^5

*/



class Solution{
    public int cutRod(int price[], int n) {
        int[] newPrice = new int[n+1];
        for(int i=1; i<=n; i++) {
            newPrice[i] = price[i-1];
        }
        
        for(int i=2; i<=n; i++) {
            int left = 1;
            int right = i-1;
            
            while(left <= right) {
                newPrice[i] = Math.max(newPrice[i], newPrice[left]+newPrice[right]);
                left++;
                right--;
            }
        }
        
        return newPrice[n];
    }
}

/*

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
  Input: nums = [-4,-1,0,3,10]
  Output: [0,1,9,16,100]
  Explanation: After squaring, the array becomes [16,1,0,9,100]. After sorting, it becomes [0,1,9,16,100].

Example 2:
  Input: nums = [-7,-3,2,3,11]
  Output: [4,9,9,49,121]

Constraints:
  1 <= nums.length <= 10^4
  -10^4 <= nums[i] <= 10^4
  nums is sorted in non-decreasing order.

*/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int l = 0;
        int r = n-1;
        int idx = n-1;

        while(l<=r) {
            if(Math.abs(nums[l]) >= Math.abs(nums[r])) {
                ans[idx] = nums[l]*nums[l];
                l++;
            } else {
                ans[idx] = nums[r]*nums[r];
                r--;
            }
            idx--;
        }

        return ans;
    }
}

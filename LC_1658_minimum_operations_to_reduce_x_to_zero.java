/*

You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or 
the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

Example 1:
  Input: nums = [1,1,4,2,3], x = 5
  Output: 2
  Explanation: The optimal solution is to remove the last two elements to reduce x to zero.

Example 2:
  Input: nums = [5,6,7,8,9], x = 4
  Output: -1

Example 3:
  Input: nums = [3,2,20,1,1,3], x = 10
  Output: 5
  Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 
Constraints:
  1 <= nums.length <= 10^5
  1 <= nums[i] <= 10^4
  1 <= x <= 10^9

*/



class Solution {
   public int minOperations(int[] nums, int x) {
    int sum = 0;
    for (int num: nums) sum += num;

    int maxLength = -1, currSum = 0;
    for (int l=0, r=0; r<nums.length; r++) {
      currSum += nums[r];
      while (l <= r && currSum > sum - x) currSum -= nums[l++];
      if (currSum == sum - x) maxLength = Math.max(maxLength, r-l+1);
    }

    return maxLength == -1 ? -1 : nums.length - maxLength;
  }
}

/*

Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

Example 1:
  Input: s = "zzazz"
  Output: 0
  Explanation: The string "zzazz" is already palindrome we don't need any insertions.

Example 2:
  Input: s = "mbadm"
  Output: 2
  Explanation: String can be "mbdadbm" or "mdbabdm".

Example 3:
  Input: s = "leetcode"
  Output: 5
  Explanation: Inserting 5 characters the string becomes "leetcodocteel".

Example 4:
  Input: s = "g"
  Output: 0

Example 5:
  Input: s = "no"
  Output: 1
 
Constraints:
  1 <= s.length <= 500
  All characters of s are lower case English letters

*/


class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(j==i) {
                    dp[i][j] = 1;
                } else {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i+1][j-1]+2;
                    } else {
                        dp[i][j]  = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return n-dp[0][n-1];
    }
}

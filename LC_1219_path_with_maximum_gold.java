/*

In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:
  Every time you are located in a cell you will collect all the gold in that cell.
  From your position, you can walk one step to the left, right, up, or down.
  You can't visit the same cell more than once.
  Never visit a cell with 0 gold.
  You can start and stop collecting gold from any position in the grid that has some gold.
 

Example 1:
  Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
  Output: 24
  Explanation:
    [[0,6,0],
     [5,8,7],
     [0,9,0]]
    Path to get the maximum gold, 9 -> 8 -> 7.

Example 2:
  Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
  Output: 28
  Explanation:
    [[1,0,7],
     [2,0,6],
     [3,4,5],
     [0,3,0],
     [9,0,20]]
    Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 

Constraints:
  m == grid.length
  n == grid[i].length
  1 <= m, n <= 15
  0 <= grid[i][j] <= 100
  There are at most 25 cells containing gold.

*/


class Solution {
    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] != 0) {
                    int gold = helper(grid, i, j, visited);
                    ans = Math.max(ans, gold);
                }
            }
        }
        
        return ans;
    }
    
    int helper(int[][] grid, int i, int j, boolean[][] visited) {
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0) {
            return 0;
        }
        
        if(grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        
        visited[i][j] = true;
        int collectedGold = 0;
        collectedGold = Math.max(collectedGold, helper(grid, i-1, j, visited));
        collectedGold = Math.max(collectedGold, helper(grid, i+1, j, visited));
        collectedGold = Math.max(collectedGold, helper(grid, i, j-1, visited));
        collectedGold = Math.max(collectedGold, helper(grid, i, j+1, visited));
        visited[i][j] = false;
        return collectedGold+grid[i][j];
    }
}

class Solution {
   int m;
    int n;
    int[][] directions = {{-1, 1}, {0, 1}, {1, 1}}; // move up-right, right, down-right

    int Dfs(int row, int col, int[][] grid,int [][]t) {
        int moves = 0;
        if(t[row][col]!=-1){
            return t[row][col];
        }
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] > grid[row][col]) {
                moves = Math.max(moves, 1 + Dfs(newRow, newCol, grid,t));
            }
        }
        return  t[row][col]=moves;
    }

    public int maxMoves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][]t=new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                t[i][j]=-1;
            }
        }
        int result = 0;
        for (int row = 0; row < m; row++) {
            result = Math.max(result, Dfs(row, 0, grid,t));
        }
        return result;
    }
}
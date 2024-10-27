class Solution {
    int m;
    int n;
    int solve(int i, int j,int[][]matrix,int[][]dp){
     if( i >= m || j >= n ||matrix[i][j]==0){
         return 0;
     }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
       int right=solve(i,j+1,matrix,dp);
        int diag=solve(i+1,j+1, matrix,dp);
        int below=solve(i+1, j,matrix,dp);
        return dp[i][j]= 1 +  Math.min(right, Math.min(diag, below));
    }
    public int countSquares(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        int result=0;
        int[][]dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==1){
                    result+=solve(i,j,matrix,dp);
                }
            }
        }
        return result;
    }
}
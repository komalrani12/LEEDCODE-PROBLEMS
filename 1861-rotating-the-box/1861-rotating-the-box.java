class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m=box.length;
        int n=box[0].length;
        
        char result[][]=new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                result[i][j]=box[j][i];
            }
        }
        for(int i=0; i<n; i++){
         reverse(result[i]);
            
            }
        //gravity
        for(int j=0; j<m;j++){
            for(int i=n-1; i>=0; i--){
                if(result[i][j]=='.'){
                    int rowStone=-1;
                    for(int k=i-1; k>=0;k--){
                        if(result[k][j]=='*'){
                            break;
                        }
                        if(result[k][j]=='#'){
                            rowStone=k;
                            break;
                        }
                    }
                    if(rowStone!=-1){
                        result[rowStone][j]='.';
                        result[i][j]='#';
                    }
                }
            }
        }
        return result;
    }
    private void reverse(char[]row){
        int left=0;
        int right=row.length-1;
         while (left < right) {
            char temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
    
 }

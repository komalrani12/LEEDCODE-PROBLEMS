class Solution {
    static boolean ispossible(int x,int[] quantities,int shops){
        for(int product:quantities){
            shops-=(product+x-1)/x;
            if(shops<0){
                return false;
            }
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int m= quantities.length;
        int l=1;
        int r=1000000;
        int result=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(ispossible(mid,quantities,n)){
                result=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }  
        }
        return result;
    }
}
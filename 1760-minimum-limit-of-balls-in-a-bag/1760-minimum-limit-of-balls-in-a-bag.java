class Solution {
    boolean isPossible(int middle, int[]nums,int maxOperations ){
        int totaloperation=0;
        for(int num:nums){
            int operations=num/middle;
            if(num%middle==0){
                operations-=1;
            }
            totaloperation+=operations;
        }
        return totaloperation<=maxOperations;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int left=1;
        int right=0;
        int result=right;
        for(int num:nums){
            right=Math.max(right,num);
        }
        while(left<=right){
            int middle=(left+right)/2;
            if(isPossible(middle,nums,maxOperations)){
               result=middle;
                right=middle-1;
            }else{
                left=middle+1;
            }
        }
        return result;
            
    }
}
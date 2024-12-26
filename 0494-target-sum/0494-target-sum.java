class Solution {
    public static int solve(int[] nums, int target,int idx,int currsum){
        if(idx==nums.length){
            if(currsum==target){
            return 1;
        }else{
            return 0;
        }
      }
        int plus=solve(nums,target,idx+1,currsum+nums[idx]);
        int minus=solve(nums,target,idx+1,currsum-nums[idx]);
        return plus+minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
       return solve(nums,target,0,0); 
    }
}
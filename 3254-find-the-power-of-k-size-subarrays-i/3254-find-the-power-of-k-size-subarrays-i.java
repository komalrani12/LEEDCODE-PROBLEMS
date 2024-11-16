class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        
         int count=1;
        
        int result[]=new int[n-k+1];
        for(int idx=0; idx<result.length; idx++){
            result[idx]=-1;
        }
        for(int i=1; i<k; i++){
            if(nums[i-1]+1==nums[i]){
              count++;  
            }else{
                count=1;
            }
        }
        if(count==k){
            result[0]=nums[k-1];
        }
        int i=1; 
        int j=k;
        while(j<n){
            if(nums[j-1]+1==nums[j]){
                count++;
            }else{
               count=1; 
       }
            if(count>=k){
                result[i]=nums[j];
            }
            i++;
            j++;
            
        }
        return result;
        
    }
}
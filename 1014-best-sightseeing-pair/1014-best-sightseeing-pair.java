class Solution {
    public int maxScoreSightseeingPair(int[] values) {
       
           int n = values.length;
        int[] arr = new int[n];
        arr[0] = values[0] + 0;

    
        for (int i = 1; i < n; i++) {
            arr[i] = Math.max(arr[i - 1], values[i] + i);
        }

        int result = 0;
        for(int j=1; j<n; j++){
            int x=values[j]-j;
            int y=arr[j-1];
             result=Math.max(result,x+y);
        }
        return result;
       } 
    }

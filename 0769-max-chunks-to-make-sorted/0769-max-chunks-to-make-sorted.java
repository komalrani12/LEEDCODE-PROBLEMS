class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int chunks=0;
        int MaxElement=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
             MaxElement=Math.max( MaxElement,arr[i]);
            if( MaxElement<i+1){
                chunks++;
            }
        }
        return chunks;
    }
}
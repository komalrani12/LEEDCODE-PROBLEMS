class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n=nums.length;
        ArrayList<Pair<Integer,Integer>>intervals=new ArrayList<>(n);
        for(int i=0; i<n; i++){
            intervals.add( new Pair(nums[i]-k,nums[i]+k));
        }
         intervals.sort(Comparator.comparingInt(Pair::getKey));
        Queue<Integer>que=new LinkedList<>();
        int maxBeauty=0;
        for(Pair<Integer,Integer>interval:intervals){
            while(!que.isEmpty()&& 
                 que.peek() < interval.getKey()){
                que.poll();
            }
            que.add(interval.getValue());
            maxBeauty=Math.max(maxBeauty,que.size());
        }
        return maxBeauty;
    }
}
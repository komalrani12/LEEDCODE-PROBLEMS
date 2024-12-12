class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
         long sum=0;
        for(int gift:gifts){
            pq.add(gift);
            sum+=gift;
        }
         long mysum=0;
        while(k-->0){
            int maxel=pq.poll();
            int remaining=(int)Math.sqrt(maxel);
            mysum+=maxel-remaining;
            pq.add(remaining);
        }
        return sum-mysum;
    }
}
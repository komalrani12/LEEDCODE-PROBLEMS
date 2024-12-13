class Solution {
    public long findScore(int[] nums) {
        List<Pair<Integer,Integer>>list=new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            list.add(new Pair<>(nums[i],i));
        }
        list.sort((a,b)->Integer.compare(a.getKey(),b.getKey()));
         long score=0;
         boolean[] visited=new boolean[nums.length];
        for(Pair<Integer,Integer>pair:list){
            int smallest=pair.getKey();
            int index=pair.getValue();
            if((index > 0 && visited[index - 1]) || visited[index] || (index < nums.length - 1 && visited[index + 1])){
                continue;
            }
                visited[index]=true;
            score+=smallest;
        }
    
        return score;
    }
}
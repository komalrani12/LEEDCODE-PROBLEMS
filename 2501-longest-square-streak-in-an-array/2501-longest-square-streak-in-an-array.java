class Solution {
    public int longestSquareStreak(int[] nums){
        Arrays.sort(nums);
        int maxStreak = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int root = (int) Math.sqrt(nums[i]);
            
            if (root * root == nums[i] && map.containsKey(root)) {
                map.put(nums[i], map.get(root) + 1);
            } else {
                map.put(nums[i], 1);
            }
            
            maxStreak = Math.max(maxStreak, map.get(nums[i]));
        }
        
        return maxStreak < 2 ? -1 : maxStreak;
    }

}
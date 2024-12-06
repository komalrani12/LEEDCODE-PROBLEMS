class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer>set=new HashSet<>();
        int sum=0;
        int count=0;
        int m=banned.length;
        for(int i=0; i<m; i++){
            set.add(banned[i]);
        }
        for(int i=1; i<=n; i++){
            if(set.contains(i)) continue;
            if(sum+i<=maxSum){
                count++;
                sum+=i;
            }else{
                break;
            }
        }
        return count;
    }
}
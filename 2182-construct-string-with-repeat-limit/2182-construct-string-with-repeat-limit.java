class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int []freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        StringBuilder result=new StringBuilder();
        int i=25;
         while(i>=0){
             if(freq[i]==0){
                 i--;
                 continue;
             }
            
             int  min=Math.min(freq[i],repeatLimit);
             for(int k=0; k<min; k++){
                 result.append((char)('a'+i));
             }
             freq[i]-=min;
             if(freq[i]>0){
                 int j=i-1;
                 while(j>=0 && freq[j]==0){
                     j--;
                 }
                 if(j<0){
                     break;
                 }
                 result.append((char)('a'+j));
                 freq[j]--;
             }
         }
        return result.toString();
        
    }
}
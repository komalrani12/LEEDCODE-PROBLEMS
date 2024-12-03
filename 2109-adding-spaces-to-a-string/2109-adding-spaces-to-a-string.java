class Solution {
    public String addSpaces(String s, int[] spaces) {
      int m=s.length();
        int n=spaces.length;
        int j=0; 
        StringBuilder result=new StringBuilder();
        for(int i=0; i<m; i++){
            if(  j<n && i==spaces[j]){
                result.append(' ');
                j++;
            }
            result.append(s.charAt(i));
        }
        return result.toString();
        
    }
}
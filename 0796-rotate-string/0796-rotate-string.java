class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        int length=s.length();
        char[]sChars=s.toCharArray();
        for(int i=0; i<length; i++){
            sChars=rotateonce(sChars);
            if(new String(sChars).equals(goal)) return true;
        }
        return false;
    }
    private char[] rotateonce(char[]arr){
        char firstChar=arr[0];
        System.arraycopy(arr,1,arr,0,arr.length-1);
        arr[arr.length-1]=firstChar;
        return arr;
    }
}
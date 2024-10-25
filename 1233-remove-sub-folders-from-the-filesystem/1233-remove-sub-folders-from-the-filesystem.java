class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder,
        Comparator.comparingInt(String::length));
        HashSet<String>set=new HashSet<>();
        for(String dir:folder){
            String []dirparts=dir.split("/");
            String parentDir="";
            boolean isSubfolder=false;
            for(int i=1; i<dirparts.length;i++){
                parentDir+="/"+dirparts[i];
                if(set.contains(parentDir)){
                    isSubfolder=true;
                    break;
                }
            }
            if(!isSubfolder){
                set.add(parentDir);
            }
        }
        return new ArrayList<>(set);
    }
}
class Solution {
    private int bfs(int n,List<List<Integer>>adjList){
        boolean[]visited=new boolean[n];
        Queue<Integer>Queue=new LinkedList<>();
        Queue.add(0);
        visited[0]=true;
         
        int currentLayerNodeCount=1;
        int nextLayerNodeCount=0;
        int layersExplored=0;
        
        while(!Queue.isEmpty()){
            for(int i=0; i<currentLayerNodeCount;i++){
                int currentNode=Queue.poll();
                if(currentNode==n-1){
                    return layersExplored;
                }
                for (int neighbor : adjList.get(currentNode)) {
                    if (visited[neighbor]) continue;
                    Queue.add(neighbor); 
                    nextLayerNodeCount++; 
                    visited[neighbor] = true;
            }
        }
              currentLayerNodeCount = nextLayerNodeCount;
            nextLayerNodeCount = 0; 
            layersExplored++;
        
    }
        return -1;
    }
    
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer> answer=new ArrayList<>();
        List<List<Integer>>adjsList=new ArrayList<>(n);
        for(int i=0; i<n; i++){
            adjsList.add(new ArrayList<>());
        }
        for(int i=0; i<n-1;i++){
            adjsList.get(i).add(i+1);
        }
        for(int[]road:queries){
            int u=road[0];
            int v=road[1];
            adjsList.get(u).add(v);
            answer.add(bfs(n,adjsList));
        }
        
        return answer.stream().mapToInt(i->i).toArray();
        
    }
}
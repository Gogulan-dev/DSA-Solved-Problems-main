class Solution {
    private HashMap<Integer, List<Integer>> adj = new HashMap<>();
    private HashSet<Integer> cycStruc = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        if(!dfs(0,-1)){
            return false;
        }
        return cycStruc.size() == n;
    }
    public boolean dfs(int i ,int parent){
        if(cycStruc.contains(i)){
            return false;
        }
        cycStruc.add(i);
        for(int neigh: adj.get(i)){
            if(neigh == parent){
                continue;
            }
            if(!dfs(neigh, i)){
                return false;
            }
        }
        return true;
    }
}

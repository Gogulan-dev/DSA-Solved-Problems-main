class Solution {
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                dfs(i);
                count++;
            }
        }
        return count;
    }
    private void dfs(int node){
        if(visited.contains(node)){
            return;
        }
        visited.add(node);
        List<Integer> neighs = adj.get(node);
        for(int neigh: neighs){
            dfs(neigh);
        }
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> visited = new HashSet<>();
        Queue<String> bfs = new LinkedList<>();
        bfs.offer(beginWord);
        visited.add(beginWord);
        int count = 0;
        while(!bfs.isEmpty()){
            int size = bfs.size();
            count++;
            for(int i = 0; i < size; i++){
            String cur = bfs.poll();
            for(String neigh : wordList){
                if(!visited.contains(neigh)){
                    if(valid(cur, neigh)){
                        if(endWord.equals(neigh)){
                            return count + 1;
                        }
                        visited.add(neigh);
                        bfs.offer(neigh);
                    }
                }
            }
            }
        }
        return 0;
    }
    private boolean valid(String cur, String neigh){
        int n = cur.length();
        for(int i = 0; i < cur.length(); i++){
            if(cur.charAt(i) == neigh.charAt(i)){
                n--;
            }
        }
        return n == 1?true:false;
    }
}

// https://leetcode.com/problems/find-if-path-exists-in-graph/description/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            graph.putIfAbsent(x, new ArrayList<>());
            graph.putIfAbsent(y, new ArrayList<>());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        Queue<Integer> bfs = new ArrayDeque<>();
        bfs.add(source);
        Set<Integer> visited = new HashSet<>();
        visited.add(source);

        while(!bfs.isEmpty()){
            int node = bfs.poll();
            if(node == destination){
                return true;
            }
            if(!graph.containsKey(node)){
                continue;
            }
            for(int child: graph.get(node)){
                if(!visited.contains(child)){
                    visited.add(child);
                    bfs.add(child);
                }
            }
        }
        return false;
    }
}
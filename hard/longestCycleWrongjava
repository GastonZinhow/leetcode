// https://leetcode.com/problems/longest-cycle-in-a-graph/

class Solution {
    public int longestCycle(int[] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            if(edges[i] != -1){
                graph.putIfAbsent(i, new ArrayList<>());
                graph.get(i).add(edges[i]);
            }
        }

        int longest = -1;

        for(int i=0; i<edges.length; i++){
            Queue<Integer> bfs = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            int pathLength = 0;
            bfs.add(i);
            while(!bfs.isEmpty()){
                int node = bfs.poll();
                if(!graph.containsKey(node)){
                    continue;
                }
                for(int child: graph.get(node)){
                    if(!visited.contains(child)){
                        visited.add(child);
                        bfs.add(child);
                        pathLength++;
                    }
                }
                if(visited.contains(node)){
                    longest = pathLength;
                }
                visited.add(node);
            }
        }

        return longest;
    }
}
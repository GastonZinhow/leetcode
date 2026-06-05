// https://leetcode.com/problems/find-a-safe-walk-through-a-grid/

class Solution {
    static class State {
        int row;
        int col;
        int health;

        State(int row, int col, int health) {
            this.row = row;
            this.col = col;
            this.health = health;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int rows = grid.size();
        int cols = grid.get(0).size();

        int startHealth = health - grid.get(0).get(0);

        if (startHealth <= 0) {
            return false;
        }

        int[][] best = new int[rows][cols];

        for (int[] row : best) {
            Arrays.fill(row, -1);
        }

        Queue<State> queue = new LinkedList<>();

        queue.offer(new State(0, 0, startHealth));
        best[0][0] = startHealth;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {

            State current = queue.poll();

            if (current.row == rows - 1 &&
                current.col == cols - 1) {
                return true;
            }

            for (int[] dir : dirs) {

                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];

                if (newRow < 0 || newRow >= rows ||
                    newCol < 0 || newCol >= cols) {
                    continue;
                }

                int newHealth = current.health - grid.get(newRow).get(newCol);

                if (newHealth <= 0) {
                    continue;
                }

                if (newHealth <= best[newRow][newCol]) {
                    continue;
                }

                best[newRow][newCol] = newHealth;

                queue.offer(new State(newRow, newCol, newHealth));
            }
        }

        return false;
    }
    
}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Islands {
    public int n_islands(String[][] grid) {
        int cnt = 0;
        for(int i=0;i < grid.length;i++) {
            for(int j=0;j < grid[i].length;j++) {
                if(grid[i][j].equals("1")) {
                    cnt++;
                    bfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    public void dfs(String[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j].equals("0")) return;
        grid[i][j] = "0"; // mark as visited
        dfs(grid, i-1, j); // up
        dfs(grid, i+1, j); // down
        dfs(grid, i, j-1); // left
        dfs(grid, i, j+1); // right
    }

    public void bfs(String[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        grid[i][j] = "0";
        while(!q.isEmpty()) {
            int[] coords = q.poll();
            int x = coords[0], y = coords[1];
            int[][] options = new int[][]{{x-1, y}, {x+1, y}, {x, y-1}, {x, y+1}};
            for (int k=1;k<4;k++) {
                coords = options[k];
                x = coords[0];
                y = coords[1];

                if(0 <= x && x < grid.length && 0 <= y && y < grid[x].length && grid[x][y].equals("1")) {
                    grid[x][y] = "0";
                    q.add(coords);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[][] grid = {
                {"1", "1", "1", "1", "0"},
                {"1", "1", "0", "1", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "1", "0", "0"},
                {"0", "0", "0", "1", "1"}
        };
        Islands islands = new Islands();
        int cnt = islands.n_islands(grid);

        System.out.println(cnt);
    }
}

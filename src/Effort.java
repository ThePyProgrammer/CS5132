import java.util.Arrays;

public class Effort {
    public int pathEffort(int[][] grid, int x, int y) {
        if(x+1==grid.length && y+1==grid[x].length) return 0;
        int cH = grid[x][y];
        int nH;

        int[][] markedGrid = new int[grid.length][];
        for(int i=0;i<grid.length;i++) markedGrid[i] = grid[i].clone();
        markedGrid[x][y] = 0;
        int[][] options = new int[][]{{x-1, y}, {x+1, y}, {x, y-1}, {x, y+1}};
        int minPath = 100000000;

        for(int[] option: options) {
            int nx = option[0], ny = option[1];
            if(0 > nx || nx >= grid.length || 0 > ny || ny >= grid[nx].length || (nH=grid[nx][ny]) == 0) continue;
            int pathEffortGotten = pathEffort(markedGrid, nx, ny);
            if(pathEffortGotten >= 100000000) continue;
            int pathTaken = Math.max(pathEffortGotten,Math.abs(nH-cH));
            minPath = Math.min(minPath, pathTaken);

        }

        return minPath;
    }

    public int minimumEffortPath(int[][] heights) {
        return pathEffort(heights, 0, 0);
    }

    public static void main(String[] args) {
        Effort effort = new Effort();

        int[][] heights = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(effort.minimumEffortPath(heights));

        heights = new int[][]{{1,2,3},{3,8,4},{5,3,5}};
        System.out.println(effort.minimumEffortPath(heights));

        heights = new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
        System.out.println(effort.minimumEffortPath(heights));
    }
}

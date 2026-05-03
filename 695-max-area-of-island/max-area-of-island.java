class Solution {
        int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};
                
                    public int maxAreaOfIsland(int[][] grid) {
                            int m = grid.length, n = grid[0].length, maxArea = 0;
                                    for (int i = 0; i < m; i++)
                                                for (int j = 0; j < n; j++)
                                                                if (grid[i][j] == 1)
                                                                                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                                                                                            return maxArea;
                                                                                                }
                                                                                                    
                                                                                                        private int dfs(int[][] g, int r, int c) {
                                                                                                                if (r < 0 || r >= g.length || c < 0 || c >= g[0].length || g[r][c] == 0) return 0;
                                                                                                                        g[r][c] = 0;
                                                                                                                                int area = 1;
                                                                                                                                        for (int d = 0; d < 4; d++)
                                                                                                                                                    area += dfs(g, r + dr[d], c + dc[d]);
                                                                                                                                                            return area;
                                                                                                                                                                }
                                                                                                                                                                }


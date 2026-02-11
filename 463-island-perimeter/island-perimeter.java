class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        int[][] neighBours = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    Queue<int[]> lands = new LinkedList<>();
                    lands.add(new int[]{i, j});
                    visited[i][j] = true;
                    int perimeter = 0;

                    while (!lands.isEmpty()) {
                        int[] currentLand = lands.poll();
                        int landRow = currentLand[0];
                        int landColumn = currentLand[1];

                        for (int[] neighBour : neighBours) {
                            int nextRow = neighBour[0] + landRow;
                            int nextColumn = neighBour[1] + landColumn;
                            if (nextRow < 0 || nextColumn < 0 || nextRow >= row || nextColumn >= column || grid[nextRow][nextColumn] == 0) {
                                perimeter++;
                            } else if (!visited[nextRow][nextColumn]) {
                                visited[nextRow][nextColumn] = true;
                                lands.add(new int[]{nextRow, nextColumn});
                            }
                        }
                    }
                    return perimeter;
                }
            }
        }
        return 0;
    }
}
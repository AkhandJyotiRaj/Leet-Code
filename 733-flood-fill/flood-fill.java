class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;

        int oldcolor = image[sr][sc];
        if (oldcolor == color) {
            return image;
        }
        dfs(sr, sc, oldcolor, image, color);
        return image;
    }

    void dfs(int i, int j, int oldcolor, int[][] image, int color) {

        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldcolor) {
            return;
        }

        image[i][j] = color;
        dfs(i - 1, j, oldcolor, image, color);
        dfs(i + 1, j, oldcolor, image, color);
        dfs(i, j - 1, oldcolor, image, color);
        dfs(i, j + 1, oldcolor, image, color);

    }

}
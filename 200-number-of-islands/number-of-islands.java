class Solution {

    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row=row;
            this.col = col;
        }
    }

    public boolean isValid(int row, int col, int totalRows, int totalCols){
        if(row>=0 && row<totalRows && col>=0 && col<totalCols) return true;
        return false;

    }

    int rowDirection[] ={1,-1,0,0};
    int colDirection[] ={0,0,1,-1};

    public void bfs(boolean isVisited[][],char[][] grid, int currRow, int currCol, int totalRows, int totalCols){
        Queue<Pair> q = new LinkedList<>();

        Pair p = new Pair(currRow,currCol);
        q.add(p);
        isVisited[currRow][currCol] = true;

        while(!q.isEmpty()){
            Pair curr = q.poll();

            int currPairRow = curr.row;
            int currPairCol = curr.col;

            for(int i=0;i<4;i++){

                int newRow = currPairRow + rowDirection[i];
                int newCol = currPairCol + colDirection[i];

                if(isValid(newRow,newCol,totalRows,totalCols) && grid[newRow][newCol]=='1' && isVisited[newRow][newCol]==false){
                    isVisited[newRow][newCol] = true;
                    Pair temp = new Pair(newRow,newCol);
                    q.add(temp);
                }

            }




        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean isVisited[][] = new boolean[n][m];
        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j]=='1' && isVisited[i][j]==false){
                    count++;
                    bfs(isVisited,grid,i,j,n,m);
                }
            }
        }

        return count;
        
    }
}
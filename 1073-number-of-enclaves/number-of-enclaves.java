class Pair{
    int row;
    int col;
    Pair(int _row,int _col){
      this.row=_row;
      this.col=_col;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int [][] vis = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();

        // First and Last Row
        for(int i=0;i<n;i++){
            if(grid[0][i]==1){
                queue.offer(new Pair(0,i));
                vis[0][i]=1;
            }
            if(grid[m-1][i]==1){
                queue.offer(new Pair(m-1,i));
                vis[m-1][i]=1;
            }
        }

        // First and Last Column
        for(int i=0;i<m;i++){
            if(grid[i][0]==1){
                queue.offer(new Pair(i,0));
                vis[i][0]=1;
            }
            if(grid[i][n-1]==1){
                queue.offer(new Pair(i,n-1));
                vis[i][n-1]=1;
            }
        }

        int[] directionRow={-1,0,1,0};
        int[] directionCol={0,1,0,-1};

        // BFS
        while(queue.size()>0){
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.poll();

            for(int i=0;i<4;i++){
                int newRow=row+directionRow[i];
                int newCol=col+directionCol[i];

                if(newRow>=0 && newRow<m &&
                   newCol>=0 && newCol<n &&
                   vis[newRow][newCol]==0 &&
                   grid[newRow][newCol]==1){

                    queue.offer(new Pair(newRow,newCol));
                    vis[newRow][newCol]=1;
                }
            }
        }

        // Count enclaves
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    count++;
                }
            }
        }

        return count;
    }
}
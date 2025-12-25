class Solution {
    List<List<String>> result=new ArrayList<>();
    
    public boolean valid(List<String> board,int row,int col){
        for(int i=row;i>=0;i--){
            if(board.get(i).charAt(col)=='Q'){
                return false;
            }
        }

        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board.get(i).charAt(j)=='Q'){
                return false;
            }
        }
        for(int i=row,j=col;i>=0 && j<board.size();i--,j++){
            if(board.get(i).charAt(j)=='Q'){
                return false;
            }
        }
        return true;
    }
    
    public void solve(List<String> board,int row){
        if(row==board.size()){
            result.add(new ArrayList<>(board));
            return;
        }
        for(int col=0;col<board.size();col++){
            if(valid(board,row,col)){
                StringBuilder sb=new StringBuilder(board.get(row));
                sb.setCharAt(col,'Q');
                board.set(row,sb.toString());
                solve(board,row+1);
                sb.setCharAt(col,'.');
                board.set(row,sb.toString());
            }
        }
        
    }
    
    
    
    
    public List<List<String>> solveNQueens(int n) {
        if(n==0) return result;
        List<String> board=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(".");
            }
            board.add(sb.toString());
        }

        solve(board,0);
        return result;
    }
}
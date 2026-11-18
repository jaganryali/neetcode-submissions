class Solution {
    public void solve(char[][] board) {

        for(int c = 0; c < board[0].length; c++){
            if(board[0][c] == 'O')
                capture(board, 0, c);

            if(board[board.length - 1][c] == 'O')
                capture(board, board.length-1, c);
        }


        for(int r = 0; r < board.length; r++){
            if(board[r][0] == 'O')
                capture(board, r, 0);

            if(board[r][board[r].length-1] == 'O'){
                capture(board, r, board[r].length -1);
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
        
    }

    public void capture(char[][] board, int r, int c) {

        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O'){
            return;
        }

        board[r][c] = 'T';

        capture(board, r+1, c);
        capture(board, r-1, c);
        capture(board, r, c+1);
        capture(board, r, c-1);

    }
}

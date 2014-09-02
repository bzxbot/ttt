package info.botelho.ttt;

public class Board {
    
    public static char EmptyCell = ' ';
    
    public char[][] board;
    
    public Board() {
        this.board = new char[3][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                this.board[i][j] = ' ';
            }
        }
    }
    
    public Board(char[][] board) {
        this.board = new char[3][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }
    
    public void setSymbolAt(int row, int col, Player player) {
        this.board[row][col] = player.getSymbol();
    }
    
    public void setSymbolAt(int row, int col, char symbol) {
        this.board[row][col] = symbol;
    }
    
    public char getSymbolAtPosition(int row, int col) {
        return board[row][col];
    }
}

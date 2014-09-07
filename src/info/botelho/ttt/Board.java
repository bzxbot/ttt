package info.botelho.ttt;

public class Board {    
    
    private BoardSpace[][] boardSpaces;
    
    public Board(BoardSpace[][] boardSpaces) {
        this.boardSpaces = boardSpaces;
    }
    
    public Board() {
        this.boardSpaces = new BoardSpace[3][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                this.boardSpaces[i][j] = null;
            }
        }
    }
    
    public BoardSpace[][] getBoardSpaces() {
        return this.boardSpaces;
    }
    
    public void setSymbolAt(int row, int col, Player player) {
        this.boardSpaces[row][col].setSymbol(player.getSymbol());
    }
    
    public GameSymbol getSymbolAtPosition(int row, int col) {
        return boardSpaces[row][col].getSymbol();
    }
}

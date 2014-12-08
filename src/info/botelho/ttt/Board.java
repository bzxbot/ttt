package info.botelho.ttt;

public class Board {    
    
    private BoardCell[][] grid;
    
    public Board(char[][] grid) {
        this.grid = new BoardCell[3][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                switch(grid[i][j]) {
                    case 'X':
                        this.grid[i][j] = new BoardCell(GameSymbol.X);
                        break;
                    case 'O':
                        this.grid[i][j] = new BoardCell(GameSymbol.O);
                        break;
                    case ' ':
                        this.grid[i][j] = new BoardCell(GameSymbol.Blank);
                        break;
                }
            }
        }
    }
    
    public Board(BoardCell[][] grid) {
        this.grid = new BoardCell[3][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                this.grid[i][j] = new BoardCell(grid[i][j].getSymbol());
            }
        }
    }
    
    public Board() {
        this.grid = new BoardCell[3][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                this.grid[i][j] = new BoardCell(GameSymbol.Blank);
            }
        }
    }
    
    public BoardCell[][] getGrid() {
        return this.grid;
    }
    
    public void setSymbolAt(int row, int col, Player player) {
        this.grid[row][col].setSymbol(player.getSymbol());
    }
    
    public GameSymbol getSymbolAtPosition(int row, int col) {
        return grid[row][col].getSymbol();
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                stringBuilder.append(getPrintSymbol(this.getSymbolAtPosition(i, j))).append(" | ");
            }
            stringBuilder.append(getPrintSymbol(this.getSymbolAtPosition(i, 2))).append("\n");
            stringBuilder.append("----------").append("\n");
        }
        
        for(int i = 0; i < 2; i++) {
            stringBuilder.append(getPrintSymbol(this.getSymbolAtPosition(2,i))).append(" | ");
        }
        
        stringBuilder.append(getPrintSymbol(this.getSymbolAtPosition(2, 2))).append("\n");
        
        return stringBuilder.toString();
    }
    
    public void print() {
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.print(getPrintSymbol(this.getSymbolAtPosition(i,j)) + " | ");
            }
            System.out.println(getPrintSymbol(this.getSymbolAtPosition(i,2)));
            System.out.println("----------");
        }
        
        for(int i = 0; i < 2; i++) {
            System.out.print(getPrintSymbol(this.getSymbolAtPosition(2,i)) + " | ");
        }
        
        System.out.println(getPrintSymbol(this.getSymbolAtPosition(2, 2)));
        System.out.println("");
        System.out.println("");
    }
    
    public char getPrintSymbol(GameSymbol symbol) {
        switch(symbol) {
            case Blank:
                return ' ';
            case X:
                return 'X';
            case O:
                return 'O';
        }
        return ' ';
    }
}

package info.botelho.ttt;

public class Board {    
    
    private Cell[][] grid;
    
    public Board(char[][] grid) {
        this.grid = new Cell[3][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                switch(grid[i][j]) {
                    case 'X':
                        this.grid[i][j] = new Cell(GameSymbol.X);
                        break;
                    case 'O':
                        this.grid[i][j] = new Cell(GameSymbol.O);
                        break;
                    case ' ':
                        this.grid[i][j] = new Cell(GameSymbol.Blank);
                        break;
                }
            }
        }
    }
    
    public Board(Cell[][] grid) {
        this.grid = new Cell[3][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                this.grid[i][j] = new Cell(grid[i][j].getSymbol());
            }
        }
    }
    
    public Board() {
        this.grid = new Cell[3][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                this.grid[i][j] = new Cell(GameSymbol.Blank);
            }
        }
    }
    
    public Cell[][] getGrid() {
        return this.grid;
    }
    
    public void setSymbolAt(int row, int col, Player player) {
        this.grid[row][col].setSymbol(player.getSymbol());
    }
    
    public GameSymbol getSymbolAtPosition(int row, int col) {
        return grid[row][col].getSymbol();
    }
    
    public String toString() {
        String val = "";
        return val;
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

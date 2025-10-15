package models;

public class Player {
    int id;
    private Symbol symbol;

    public Symbol getSymbol() {
        return symbol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

}

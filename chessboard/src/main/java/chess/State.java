package chess;

public enum State {
    QUEEN('Q'),
    ROOK('R'),
    BISHOP('B'),
    KING('K'),
    KNIGHT('N'),
    NONE('0');

    private Character symbol;

    State(Character symbol) {
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }
}

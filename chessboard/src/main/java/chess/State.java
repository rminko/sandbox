package chess;

public enum State {
    KING('K'),
    QUEEN('Q'),
    BISHOP('B'),
    ROOK('R'),
    KNIGHT('N'),
    NONE(' '),
    BOOKED('_');

    private Character symbol;

    State(Character symbol) {
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }
}

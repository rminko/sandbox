package chess;

public enum State {
    QUEEN('Q'),
    ROOK('R'),
    BISHOP('B'),
    KING('K'),
    KNIGHT('N'),
    NONE('0'),
    BOOKED('x');

    private Character symbol;
    private int priority;

    State(Character symbol) {
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }
}

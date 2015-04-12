package chess.board;

import chess.State;

public class Cell {

    protected State state;
    protected int x;
    protected int y;

    public Cell(State state, int x, int y) {
        this.state = state;
        this.x = x;
        this.y = y;
    }

    public Boolean isFree() {
        return State.NONE.equals(state);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cell)) {
            return false;
        }

        Cell cell = (Cell) o;

        if (x != cell.x) {
            return false;
        }
        if (y != cell.y) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

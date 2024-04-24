package at.sim.games.minesweeper;

public class Tile {

    private boolean known;
    private boolean mine;
    private int mines;
    private boolean flagged;

    public Tile(boolean mine) {
        this.known = false;
        this.mine = mine;
        this.mines = 0;
        this.flagged = false;
    }

    public boolean isKnown() {
        return known;
    }

    public void setKnown(boolean known) {
        this.known = known;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public int getMines() {
        return mines;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }
}

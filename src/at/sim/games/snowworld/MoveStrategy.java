package at.sim.games.snowworld;

public interface MoveStrategy {
    public float getX();

    public float getY();

    public void update(int delta);
}

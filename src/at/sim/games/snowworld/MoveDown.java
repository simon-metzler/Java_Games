package at.sim.games.snowworld;

public class MoveDown implements MoveStrategy {
    private float x, y, speed;

    public MoveDown(float x, float y, float speed) {
        super();
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void update(int delta) {
        this.y += delta / this.speed;
    }
}

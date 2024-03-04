package at.sim.games.objects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Cannonball implements Actor{

    private int x, y;

    public Cannonball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, 5, 5);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.y --;

    }
}

package at.sim.games.racer;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class House implements Actor {

    private Rectangle rectangle;

    public House(int x, int y, int width, int height) {

        this.rectangle = new Rectangle(x, y, width, height);

    }

    @Override
    public void render(Graphics graphics) {
        graphics.fill(rectangle);


    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }
}

package at.sim.games.snowworld;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import java.util.List;

public class Umbrella {

    private Rectangle rect;

    public Umbrella(int x, int y, int width, int height) {
        this.rect = new Rectangle(x, y, width, height);
    }


    public void render(Graphics graphics) {
        graphics.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
    }


    public void update(int delta, List<Actor> actors) {
        for (Actor actor : actors) {
            if (actor.getMd().getX() > rect.getX() && actor.getMd().getX() < rect.getX() + rect.getWidth() && actor.getMd().getY() > rect.getY() - rect.getHeight()) {
                actor.reset();
            }
        }
    }
}

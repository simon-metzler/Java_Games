package at.sim.games.snowworld;

import org.newdawn.slick.Graphics;

public interface Actor {
    public void render(Graphics graphics);

    public void update(int delta);

    public void reset();

    public MoveDown getMd();

}

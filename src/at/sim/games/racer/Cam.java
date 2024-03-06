package at.sim.games.racer;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Cam implements Actor {

    private float x;
    private float y;
    private float t_x;
    private float t_y;

    private float smooth_factor;


    public Cam(float x, float y, float smooth_factor) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }


    public void setT_x(float t_x) {
        this.t_x = t_x;
    }

    public void setT_y(float t_y) {
        this.t_y = t_y;
    }

    @Override
    public void render(Graphics graphics) {

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.x += (float) delta/((this.t_x-gameContainer.getWidth()-this.x)/this.smooth_factor);
        this.y += (float) delta/((this.t_y-gameContainer.getHeight()-this.y)/this.smooth_factor);
    }
}

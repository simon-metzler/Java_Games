package at.sim.games.objects;

import org.newdawn.slick.Graphics;

public class Object {
    private enum DIRECTION {LEFT, RIGHT, UP, DOWN};
    private float x;
    private float y;
    private float speed;

    public Object(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void render(Graphics graphics){
        graphics.drawRect(this.x, this.y, 10, 10);
    }

    public void update(int delta){
        this.x += (float)delta/this.speed;
        if (this.x > 600){
            this.x = 0;
        }

    }

}

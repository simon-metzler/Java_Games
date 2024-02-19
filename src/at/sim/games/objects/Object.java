package at.sim.games.objects;

import org.newdawn.slick.Graphics;

public class Object {
    private enum DIRECTION {LEFT, RIGHT, UP, DOWN};
    public enum TYPE {RECTANGLE, ELLIPSE}
    private float x;
    private float y;
    private float speed;
    private int width;
    private int height;

    private TYPE type;

    public Object(float x, float y, int width, int height, float speed, TYPE type) {
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;

        this.type = type;

        this.speed = speed;
    }

    public void render(Graphics graphics){
        if (this.type == TYPE.ELLIPSE) {
            graphics.drawOval(this.x, this.y, this.width, this.height);
        }
        else if (this.type == TYPE.RECTANGLE){
            graphics.drawRect(this.x, this.y, this.width, this.height);
        }
    }

    public void update(int delta){
        this.x += (float)delta/this.speed;
        if (this.x > 600){
            this.x = 0;
        }

    }

}

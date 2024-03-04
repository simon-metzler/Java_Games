package at.sim.games.objects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Object implements Actor{
    public enum DIRECTION {LEFT, RIGHT, UP, DOWN};
    public enum TYPE {RECTANGLE, ELLIPSE}
    private float x;
    private float y;
    private float speed;
    private float width;
    private float height;

    private TYPE type;
    private DIRECTION direction;

    public Object(float x, float y, float width, float height, float speed, TYPE type, DIRECTION direction) {
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;

        this.type = type;

        this.direction = direction;

        this.speed = speed;
    }

    public void render(Graphics graphics){
        if (this.type == TYPE.ELLIPSE) {
            graphics.drawOval(this.x, this.y, (int)this.width, (int)this.height);
        }
        else if (this.type == TYPE.RECTANGLE){
            graphics.drawRect(this.x, this.y, (int)this.width, (int)this.height);
        }
    }

    public void update(GameContainer gameContainer, int delta){
        if (this.direction == DIRECTION.RIGHT){
            this.x += (float)delta/this.speed;
            if (this.x > 600) {
                this.x = 0;
            }
        }

        if (this.direction == DIRECTION.LEFT){
            this.x -= (float)delta/this.speed;
            if (this.x < 0) {
                this.x = 600;
            }
        }

        if (this.direction == DIRECTION.UP){
            this.y -= (float)delta/this.speed;
            if (this.y < 0) {
                this.y = 600;
            }
        }

        if (this.direction == DIRECTION.DOWN){
            this.y += (float)delta/this.speed;
            if (this.y > 600) {
                this.y = 0;
            }
        }

        if (this.type == TYPE.ELLIPSE){
            this.width += 0.005;
            this.height += 0.005;

            if (this.width > 50){
                this.width = 0;
            }

            if (this.height > 50){
                this.height = 0;
            }
        }




    }

}

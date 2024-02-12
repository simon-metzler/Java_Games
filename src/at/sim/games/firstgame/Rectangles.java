package at.sim.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.tests.AnimationTest;

public class Rectangles extends BasicGame {

    private double rect_x;
    private double rect_y;
    private double rect_vel_x;
    private double rect_vel_y;
    private int rect_width;
    private int rect_height;
    private int window_width;
    private int window_height;

    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.rect_x = 0;
        this.rect_y = 0;
        this.rect_vel_x = 0.4f;
        this.rect_vel_y = 0.4f;
        this.rect_width = 100;
        this.rect_height = 50;
        this.window_width = 1000;
        this.window_height = 1000;

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if (this.rect_x > this.window_width-this.rect_width || this.rect_x < 0){
            this.rect_vel_x = -this.rect_vel_x;
        }
        if (this.rect_y > this.window_height-this.rect_height || this.rect_y < 0){
            this.rect_vel_y = -this.rect_vel_y;
        }

        this.rect_x += (delta*this.rect_vel_x);
        this.rect_y += (delta*this.rect_vel_y);

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect((int)this.rect_x, (int)this.rect_y, this.rect_width, rect_height);
        graphics.drawString("Hello World!", 300, 300);

    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(1000,1000,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}

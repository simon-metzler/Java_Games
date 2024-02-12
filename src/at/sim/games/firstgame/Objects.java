package at.sim.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.tests.AnimationTest;

public class Objects extends BasicGame {

    private double rect_x;
    private double rect_y;
    private double rect_vel_x;
    private double rect_vel_y;
    private int rect_width;
    private int rect_height;

    private double circle_x;
    private double circle_y;
    private double circle_vel_x;
    private double circle_vel_y;
    private int circle_radius;

    private double oval_x;
    private double oval_y;
    private double oval_vel_x;
    private double oval_vel_y;
    private int oval_width;
    private int oval_height;

    private int window_width;
    private int window_height;

    public Objects(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.rect_x = 50;
        this.rect_y = 50;
        this.rect_vel_x = 0.0f;
        this.rect_vel_y = 0.5f;
        this.rect_width = 100;
        this.rect_height = 50;

        this.circle_x = 50;
        this.circle_y = 150;
        this.circle_vel_x = 0.5f;
        this.circle_vel_y = 0.0f;
        this.circle_radius = 50;

        this.oval_x = 500;
        this.oval_y = 0;
        this.oval_vel_x = 0.2f;
        this.oval_vel_y = 0.2f;
        this.oval_width = 150;
        this.oval_height = 100;

        this.window_width = 1000;
        this.window_height = 1000;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        // Rechteck
        if (this.rect_x > this.window_width - this.rect_width || this.rect_x < 0) {
            this.rect_vel_x = -this.rect_vel_x;
        }
        if (this.rect_y > this.window_height - this.rect_height || this.rect_y < 0) {
            this.rect_vel_y = -this.rect_vel_y;
        }
        this.rect_x += (delta * this.rect_vel_x);
        this.rect_y += (delta * this.rect_vel_y);

        // Kreis
        if (this.circle_x > this.window_width - this.circle_radius || this.circle_x < this.circle_radius) {
            this.circle_vel_x = -this.circle_vel_x;
        }
        if (this.circle_y > this.window_height - this.circle_radius || this.circle_y < this.circle_radius) {
            this.circle_vel_y = -this.circle_vel_y;
        }
        this.circle_x += (delta * this.circle_vel_x);
        this.circle_y += (delta * this.circle_vel_y);

        // Oval
        if (this.oval_x > this.window_width - this.oval_width || this.oval_x < 0) {
            this.oval_vel_x = -this.oval_vel_x;
        }
        if (this.oval_y > this.window_height - this.oval_height || this.oval_y < 0) {
            this.oval_vel_y = -this.oval_vel_y;
        }
        this.oval_x += (delta * this.oval_vel_x);
        this.oval_y += (delta * this.oval_vel_y);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        // Rechteck
        graphics.drawRect((float) this.rect_x, (float) this.rect_y, this.rect_width, this.rect_height);

        // Kreis
        graphics.drawOval((float) this.circle_x - this.circle_radius, (float) this.circle_y - this.circle_radius,
                this.circle_radius * 2, this.circle_radius * 2);

        // Oval
        graphics.drawOval((float) this.oval_x, (float) this.oval_y, this.oval_width, this.oval_height);

        graphics.drawString("Hello World!", 300, 300);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Objects("Shapes"));
            container.setDisplayMode(1000, 1000, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}

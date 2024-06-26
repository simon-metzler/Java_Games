package at.sim.games.racer;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Car implements Actor {

    private float x, y;
    private float vel_x, vel_y;
    private float speed;
    private float acceleration;
    private float max_speed;

    private float direction;
    private float direction_change_speed;
    private Image car_image;
    private int steering;
    public Rectangle rectangle;

    public Car(float x, float y, float speed, float direction_change_speed) throws SlickException {
        this.x = x;
        this.y = y;
        this.vel_x = 0;
        this.vel_y = 0;
        this.direction = 0;
        this.speed = speed;
        this.direction_change_speed = direction_change_speed;
        this.steering = 0;
        this.max_speed = 1;

        Image temp = new Image("testdata/car.png");
        this.car_image = temp.getScaledCopy(50, 50);

        this.rectangle = new Rectangle(x, y, 50, 50);

    }

    @Override
    public void render(Graphics graphics) {
        this.car_image.setRotation(this.direction + 90);
        this.car_image.draw(this.x, this.y);

        //graphics.draw(this.rectangle);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        if (gameContainer.getInput().isKeyDown(Input.KEY_W)) {
            this.vel_x = (float) (Math.cos(this.direction / 180 * Math.PI) * this.speed);
            this.vel_y = (float) (Math.sin(this.direction / 180 * Math.PI) * this.speed);
            this.steering = -1;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_S)) {
            this.vel_x = (float) (Math.cos((this.direction + 180) / 180 * Math.PI) * this.speed);
            this.vel_y = (float) (Math.sin((this.direction + 180) / 180 * Math.PI) * this.speed);
            this.steering = 1;
        } else {
            this.vel_x = 0;
            this.vel_y = 0;
        }


        if (gameContainer.getInput().isKeyDown(Input.KEY_A)) {
            this.direction += this.direction_change_speed / delta * this.steering;
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_D)) {
            this.direction -= this.direction_change_speed / delta * this.steering;
        }

        if (this.vel_x < -this.max_speed) {
            this.vel_x = -this.max_speed;
        }
        if (this.vel_x > this.max_speed) {
            this.vel_x = this.max_speed;
        }
        if (this.vel_y < -this.max_speed) {
            this.vel_y = -this.max_speed;
        }
        if (this.vel_y > this.max_speed) {
            this.vel_y = this.max_speed;
        }


        this.x += this.vel_x / delta;
        this.y += this.vel_y / delta;


        if (this.x < 0) {
            this.x = 0;
        }
        if (this.x > 1000 - this.rectangle.getWidth()) {
            this.x = 1000 - this.rectangle.getWidth();
        }
        if (this.y < 0) {
            this.y = 0;
        }
        if (this.y > 1000 - this.rectangle.getHeight()) {
            this.y = 1000 - this.rectangle.getHeight();
        }

        this.rectangle.setX(this.x);
        this.rectangle.setY(this.y);


    }
}

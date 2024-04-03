package at.sim.games.racer;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import java.util.Random;

public class Goal implements Actor {

    private Random random;
    private Car car;
    private Rectangle rectangle;

    public Goal(Car car) {

        this.random = new Random();
        this.car = car;
        this.rectangle = new Rectangle(500, 500, 100, 100);

    }

    @Override
    public void render(Graphics graphics) {
        graphics.fill(this.rectangle);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if (rectangle.contains(car.rectangle.getX(), car.rectangle.getY()) && rectangle.contains(car.rectangle.getX() + car.rectangle.getWidth(), car.rectangle.getY() + car.rectangle.getHeight())) {
            updatePosition();
        }

    }


    private void updatePosition() {
        this.rectangle.setX(this.random.nextInt((int) (1000 - this.rectangle.getWidth() * 2)) + this.rectangle.getWidth());
        this.rectangle.setY(this.random.nextInt((int) (1000 - this.rectangle.getHeight() * 2)) + this.rectangle.getHeight());
    }
}

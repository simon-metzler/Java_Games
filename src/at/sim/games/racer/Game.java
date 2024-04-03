package at.sim.games.racer;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends BasicGame {


    private List<Actor> actors;
    private Color bgColor;
    private Random random;

    public Game(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();

        Car car = new Car(300, 300, 0.3f, 0.1f);
        Goal goal = new Goal(car);

        this.bgColor = new Color(200, 200, 200);

        this.random = new Random();

        boolean free_space_found = false;
        House house = new House(random.nextInt(800), random.nextInt(800), random.nextInt(100) + 100, random.nextInt(100) + 100);


        for (int i = 0; i < 10; i++) {

            house = new House(random.nextInt(800), random.nextInt(800), random.nextInt(100) + 100, random.nextInt(100) + 100);
            this.actors.add(house);
        }

        this.actors.add(goal);
        this.actors.add(car);


    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : actors) {
            actor.update(gameContainer, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.setBackground(this.bgColor);
        for (Actor actor : actors) {
            actor.render(graphics);
        }
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new Game("Spollis Drifter"));
            container.setDisplayMode(1000, 1000, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


}

package at.sim.games.racer;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Game extends BasicGame {


    private List<Actor> actors;
    public Game(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();

        Cam cam = new Cam(300, 300, 3);
        this.actors.add(cam);

        Car car = new Car(300, 300, 0.1f, 0.1f);

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

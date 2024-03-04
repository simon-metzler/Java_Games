package at.sim.games.objects;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class ObjectsGame extends BasicGame {

    private List<Actor> actors;
    private Rocket rocket;



    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {


            Object object;

            if (random.nextBoolean()) {
                object = new Object(random.nextInt(600), random.nextInt(600), random.nextInt(60), random.nextInt(60), random.nextInt(50), Object.TYPE.ELLIPSE, Object.DIRECTION.DOWN);
            }

            else {
                object = new Object(random.nextInt(600), random.nextInt(600), random.nextInt(10), random.nextInt(10), random.nextInt(50), Object.TYPE.RECTANGLE, Object.DIRECTION.RIGHT);

            }

            actors.add(object);
        }

        this.rocket = new Rocket();
        actors.add(this.rocket);



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

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE){
            Cannonball cb = new Cannonball(this.rocket.getX(), this.rocket.getY());
            actors.add(cb);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsGame("Shapes"));
            container.setDisplayMode(600, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}

package at.sim.games.objects;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class ObjectsGame extends BasicGame {

    private List<Object> objects;


    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.objects = new ArrayList<Object>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {


            Object object;

            if (random.nextBoolean()) {
                object = new Object(random.nextInt(600), random.nextInt(600), random.nextInt(10), random.nextInt(10), random.nextInt(50), Object.TYPE.ELLIPSE);
            }

            else {
                object = new Object(random.nextInt(600), random.nextInt(600), random.nextInt(10), random.nextInt(10), random.nextInt(50), Object.TYPE.RECTANGLE);

            }

            objects.add(object);
        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Object object : objects) {
            object.update(delta);
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Object object : objects) {
            object.render(graphics);
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

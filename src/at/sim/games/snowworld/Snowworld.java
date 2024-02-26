package at.sim.games.snowworld;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Snowworld extends BasicGame {


    private List<Actor> actors;


    public Snowworld(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {


            Snowflake snowflake1 = new Snowflake(Snowflake.TYPE.SMALL);
            Snowflake snowflake2 = new Snowflake(Snowflake.TYPE.BIG);
            Snowflake snowflake3 = new Snowflake(Snowflake.TYPE.MEDIUM);

            actors.add(snowflake1);
            actors.add(snowflake2);
            actors.add(snowflake3);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : actors) {
            actor.update(delta);
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
            AppGameContainer container = new AppGameContainer(new Snowworld("Snowworld"));
            container.setDisplayMode(600, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
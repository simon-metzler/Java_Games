package at.sim.games.snowworld;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Snowworld extends BasicGame {


    private List<Actor> actors;
    private Umbrella umbrella;


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
        this.umbrella = new Umbrella(200, 200, 100, 10);
    }


    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : actors) {
            actor.update(delta);
        }
        this.umbrella.update(delta, this.actors);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : actors) {
            actor.render(graphics);
        }
        this.umbrella.render(graphics);
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
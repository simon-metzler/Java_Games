package at.sim.games.snowworld;


import org.newdawn.slick.Graphics;

import java.util.Random;

public class Snowflake implements Actor{
    private float x;
    private float y;
    private int diameter;
    private int speed;

    public enum TYPE {BIG, SMALL, MEDIUM};
    private TYPE type;
    private Random random;

    public Snowflake(TYPE type) {
        this.random = new Random();
        this.type = type;
        this.x = this.random.nextInt(600);
        this.y = this.random.nextInt(600);
        if (type == TYPE.BIG){
            this.diameter = 15;
            this.speed = 7;
        }
        if (type == TYPE.MEDIUM){
            this.diameter = 11;
            this.speed = 11;
        }
        if (type == TYPE.SMALL){
            this.diameter = 7;
            this.speed = 15;
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, this.diameter, this.diameter);

    }

    @Override
    public void update(int delta) {
        this.y += (float) delta/this.speed;
        if (this.y > 600){
            this.y = 0;
            this.x = this.random.nextInt(600);
        }
    }
}

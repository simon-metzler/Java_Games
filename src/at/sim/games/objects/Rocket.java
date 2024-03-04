package at.sim.games.objects;

import org.newdawn.slick.*;

public class Rocket implements Actor{

    private int x;
    private int y;

    private Image rocketImage;


    public Rocket() throws SlickException {
        Image temp = new Image("testdata/rocket.png");
        this.rocketImage = temp.getScaledCopy(50, 50);
        this.x = 0;
        this.y = 0;
    }

    @Override
    public void render(Graphics graphics) {
        this.rocketImage.draw(x, y);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if(gameContainer.getInput().isKeyDown(Input.KEY_A)){
            this.x --;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_D)){
            this.x ++;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_W)){
            this.y --;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_S)){
            this.y ++;
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

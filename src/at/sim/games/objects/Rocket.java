package at.sim.games.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Rocket implements Actor{

    private Image rocketImage;


    public Rocket() throws SlickException {
        this.rocketImage = new Image("testdata/rocket.png");
    }

    @Override
    public void render(Graphics graphics) {
        this.rocketImage.draw(1000, 1000);
    }

    @Override
    public void update(int delta) {

    }
}

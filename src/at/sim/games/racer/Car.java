package at.sim.games.racer;

import org.newdawn.slick.*;

public class Car implements Actor{

    private float x, y;
    private float vel_x, vel_y;
    private float speed;
    private float acceleration;
    private float max_speed;

    private float direction;
    private float direction_change_speed;
    private Image car_image;
    private int steering;

    public Car(float x, float y, float speed, float direction_change_speed) throws SlickException {
        this.x = x;
        this.y = y;
        this.vel_x = 0;
        this.vel_y = 0;
        this.direction = 0;
        this.speed = speed;
        this.direction_change_speed = direction_change_speed;
        this.steering = 0;

        Image temp = new Image("testdata/car.png");
        this.car_image = temp.getScaledCopy(50, 50);

    }

    @Override
    public void render(Graphics graphics) {
        this.car_image.setRotation(this.direction+90);
        this.car_image.draw(this.x, this.y);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        if(gameContainer.getInput().isKeyDown(Input.KEY_W)){
            this.vel_x = (float) (Math.cos(this.direction/180*Math.PI)*this.speed);
            this.vel_y = (float) (Math.sin(this.direction/180*Math.PI)*this.speed);
            this.steering = -1;
        }

        else if(gameContainer.getInput().isKeyDown(Input.KEY_S)){
            this.vel_x = (float) (Math.cos((this.direction+180)/180*Math.PI)*this.speed);
            this.vel_y = (float) (Math.sin((this.direction+180)/180*Math.PI)*this.speed);
            this.steering = 1;
        }

        else {
            this.vel_x = 0;
            this.vel_y = 0;
        }


        if(gameContainer.getInput().isKeyDown(Input.KEY_A)){
            this.direction += this.direction_change_speed/delta*this.steering;
        }

        if(gameContainer.getInput().isKeyDown(Input.KEY_D)){
            this.direction -= this.direction_change_speed/delta*this.steering;
        }


        this.x += this.vel_x/delta;
        this.y += this.vel_y/delta;


        if (this.x < 10){
            this.x = 10;
        }
        if (this.x > 990){
            this.x = 990;
        }
        if (this.y < 10){
            this.y = 10;
        }
        if (this.y > 990){
            this.y = 990;
        }



    }
}

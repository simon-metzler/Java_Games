package at.sim.games.minesweeper;

import org.newdawn.slick.*;

public class Game extends BasicGame {

    private Board board;


    public Game(String title) throws SlickException {
        super(title);
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.board = new Board(50, 50, 900 / 50);
        this.board.resetBoard();


    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        this.board.update(gameContainer, i);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        this.board.render(graphics);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new Game("Minesweeper"));
            container.setDisplayMode(900, 900, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}

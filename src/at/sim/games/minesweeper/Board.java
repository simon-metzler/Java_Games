package at.sim.games.minesweeper;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board implements Actor {

    private int height;
    private int width;

    private Tile[][] board;
    private Random rng;
    private int tile_size;
    private int[][] neighbours_pos;

    private List<Image> images;

    private String[] image_names;
    private boolean game_over;
    private boolean game_finished;
    private boolean generated;


    public Board(int height, int width, int tile_size) throws SlickException {
        this.height = height;
        this.width = width;
        this.board = new Tile[this.height][this.width];
        this.neighbours_pos = new int[][]{{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};
        this.rng = new Random();
        this.tile_size = tile_size;

        this.images = new ArrayList<>();

        this.image_names = new String[]{"known", "1", "2", "3", "4", "5", "6", "7", "8", "unknown", "mine", "flag"};


        Image temp;
        for (String name : image_names) {
            temp = new Image("src/at/sim/games/minesweeper/img/" + name + ".png");
            this.images.add(temp.getScaledCopy(this.tile_size, this.tile_size));
        }

        temp = new Image("src/at/sim/games/minesweeper/img/won.png");
        this.images.add(temp.getScaledCopy(500, 300));

        temp = new Image("src/at/sim/games/minesweeper/img/lost.png");
        this.images.add(temp.getScaledCopy(500, 300));


        this.game_over = false;

        this.generated = false;


    }

    public void resetBoard() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                this.board[x][y] = new Tile(false);

            }

        }
    }

    public void generateBoard(int startX, int startY, int maxMines) {

        int minesCount = 0;
        int randomX, randomY;
        while (minesCount < maxMines) {
            randomX = this.rng.nextInt(this.width);
            randomY = this.rng.nextInt(this.height);
            if (!this.board[randomX][randomY].isMine() && randomX != startX && randomY != startY) {
                this.board[randomX][randomY].setMine(true);
                minesCount++;
            }


        }

        this.board[startX][startY].setKnown(true);
        updateMines();
    }


    public void updateMines() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {

                int mines = 0;

                for (int[] relative_neighbour_position : this.neighbours_pos) {
                    int abs_neighbour_pos_x = x + relative_neighbour_position[0];
                    int abs_neighbour_pos_y = y + relative_neighbour_position[1];

                    if (abs_neighbour_pos_x >= 0 && abs_neighbour_pos_x < this.width && abs_neighbour_pos_y >= 0 && abs_neighbour_pos_y < this.height) {
                        if (this.board[abs_neighbour_pos_x][abs_neighbour_pos_y].isMine()) {
                            mines += 1;
                        }
                    }
                }

                this.board[x][y].setMines(mines);

            }
        }
    }


    public void updateBoard() {


        boolean game_finished = true;

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {

                if (!this.board[x][y].isKnown() && !this.board[x][y].isMine()) {
                    game_finished = false;
                }

                for (int[] relative_neighbour_position : this.neighbours_pos) {
                    int abs_neighbour_pos_x = x + relative_neighbour_position[0];
                    int abs_neighbour_pos_y = y + relative_neighbour_position[1];

                    if (abs_neighbour_pos_x >= 0 && abs_neighbour_pos_x < this.width && abs_neighbour_pos_y >= 0 && abs_neighbour_pos_y < this.height) {
                        if (this.board[abs_neighbour_pos_x][abs_neighbour_pos_y].isKnown() && this.board[abs_neighbour_pos_x][abs_neighbour_pos_y].getMines() == 0) {
                            this.board[x][y].setKnown(true);
                        }

                    }

                }
            }

        }

        if (game_finished) {
            this.game_finished = true;
        }

    }


    @Override
    public void render(Graphics graphics) {
        Tile tile;
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                tile = this.board[x][y];
                if (!tile.isKnown()) {

                    if (this.game_over && this.board[x][y].isMine()) {
                        this.images.get(10).draw(x * this.tile_size, y * this.tile_size);
                    } else if (tile.isFlagged()) {
                        this.images.get(11).draw(x * this.tile_size, y * this.tile_size);
                    } else {
                        this.images.get(9).draw(x * this.tile_size, y * this.tile_size);
                    }
                } else {
                    this.images.get(tile.getMines()).draw(x * this.tile_size, y * this.tile_size);
                }


            }

        }

        if (this.game_over) {
            this.images.get(13).draw(250, 350);
        } else if (this.game_finished) {
            this.images.get(12).draw(250, 350);
        }


    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        Input input = gameContainer.getInput();

        if (!this.game_over && !this.game_finished) {

            if (input.isMousePressed(0)) {
                int x = input.getMouseX() / this.tile_size;
                int y = input.getMouseY() / this.tile_size;

                if (this.generated == false) {
                    generateBoard(x, y, 50);
                    this.generated = true;

                } else if (this.board[x][y].isMine()) {
                    this.game_over = true;

                } else if (!this.board[x][y].isKnown() && !this.board[x][y].isMine()) {
                    this.board[x][y].setKnown(true);
                }

            }


            if (input.isMousePressed(1)) {
                int x = input.getMouseX() / this.tile_size;
                int y = input.getMouseY() / this.tile_size;

                Tile tile = this.board[x][y];

                if (!tile.isKnown()) {
                    tile.setFlagged(!tile.isFlagged());
                }


            }

            updateBoard();
        } else {

            if (input.isMousePressed(0)) {
                int x = input.getMouseX();
                int y = input.getMouseY();

                if (x >= 250 && x <= 750 && y >= 250 && y <= 750) {
                    this.game_finished = false;
                    this.game_over = false;
                    this.generated = false;
                    resetBoard();

                }


            }

        }

    }
}
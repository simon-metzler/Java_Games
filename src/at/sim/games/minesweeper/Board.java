package at.sim.games.minesweeper;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board implements Actor {

    private int height;
    private int width;

    private int[][] board;
    private Random rng;
    private int tile_size;
    private int[][] neighbours_pos;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.board = new int[this.height][this.width];
        this.neighbours_pos = new int[][]{{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};
        this.rng = new Random();
        this.tile_size = 30;

    }

    public void resetBoard() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                this.board[x][y] = -2;

            }

        }
    }

    public void generateBoard(int startX, int startY, int maxMines) {
        int minesCount = 0;
        int randomX, randomY;
        while (minesCount < maxMines) {
            randomX = this.rng.nextInt(this.width);
            randomY = this.rng.nextInt(this.height);
            if (this.board[randomX][randomY] == -2 && randomX != startX && randomY != startY) {
                this.board[randomX][randomY] = -1;
                minesCount++;
            }


        }

        this.board[startX][startY] = 0;
    }

    public void updateBoard() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                if (this.board[x][y] == -2) {
                    boolean revealed = false;
                    int mines = 0;

                    for (int[] relative_neighbour_position : this.neighbours_pos) {
                        int abs_neighbour_pos_x = x + relative_neighbour_position[0];
                        int abs_neighbour_pos_y = y + relative_neighbour_position[1];

                        if (abs_neighbour_pos_x >= 0 && abs_neighbour_pos_x < this.width && abs_neighbour_pos_y >= 0 && abs_neighbour_pos_y < this.height) {
                            if (this.board[abs_neighbour_pos_x][abs_neighbour_pos_y] == -1) {
                                mines += 1;
                            }
                            if (this.board[abs_neighbour_pos_x][abs_neighbour_pos_y] == 0) {
                                revealed = true;
                            }

                        }

                    }

                    if (revealed) {
                        this.board[x][y] = mines;
                    }


                }

            }

        }
    }


    @Override
    public void render(Graphics graphics) {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                if (this.board[x][y] == -2) {
                    graphics.setColor(Color.gray);
                } else if (this.board[x][y] == -1) {
                    graphics.setColor(Color.red);
                } else if (this.board[x][y] == 0) {
                    graphics.setColor(Color.lightGray);
                } else {
                    graphics.setColor(Color.blue);
                }

                graphics.fillRect(x * this.tile_size, y * tile_size, this.tile_size, this.tile_size);

            }

        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }
}

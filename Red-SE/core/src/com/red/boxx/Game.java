package com.red.boxx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Game extends ApplicationAdapter {
    SpriteBatch batch;

    private Texture wallImg;
    private Texture areaImg;
    private Texture boxImg;
    private Texture playerImg;
    private Texture player2Img;
    private Texture ghostImg;
    private Texture zombieImg;

    private ArrayList<Sprite> wallSprites = new ArrayList<Sprite>();
    private ArrayList<Sprite> areaSprites = new ArrayList<Sprite>();
    private ArrayList<Sprite> boxSprites = new ArrayList<Sprite>();
    private ArrayList<Sprite> enemySprites = new ArrayList<Sprite>();

    private Sprite playerSprite;
    private Sprite player2Sprite;

    private Board board;

    private long startTime = 0;
    private long timeBetweenEnemyMoves = 1000000000; // 1 billion nanoseconds = 1 sec.

    Sound gameSound;
    //Sound completeLevelSound;

    @Override
    public void create () {

        Gdx.graphics.setWindowedMode(1200,600); // Think about compatibility with Android screen sizes

        gameSound = Gdx.audio.newSound(Gdx.files.internal("backgroundMusic.mp3"));
        gameSound.play(0.5f);
        //completeLevelSound = Gdx.audio.newSound(Gdx.files.internal("completeLevel.mp3"));
        batch = new SpriteBatch();

        wallImg = new Texture("temp/wall.png");
        areaImg = new Texture("temp/area.png");
        boxImg = new Texture("temp/box.png");
        playerImg = new Texture("temp/player.png");
        player2Img = new Texture("temp/player2.png");
        ghostImg = new Texture("temp/ghost.png");
        zombieImg = new Texture("temp/monster.png");

        startTime = TimeUtils.nanoTime();

        // TODO : Implement 'map' as a hardcoded input
        Board level1 = new Board("################################################\n"
                + "################################################\n"
                + "################################################\n"
                + "################################################\n"
                + "################################################\n"
                + "#####   1          .  ######                ####\n"
                + "###.   #       $ 1      ##               2   ###\n"
                + "###     #         # #   ##   $$$$$$$ $$$$$   ###\n"
                + "###. +         #  $     ##   $      $    $   ###\n"
                + "###   #     #    #   #  ##   $ $      @  $   ###\n"
                + "###.    #   #    #      ##   $$$$$$$ $$$$$   ###\n"
                + "###         #  1    $   ##          2        ###\n"
                + "####            #  #   ####                 ####\n"
                + "################################################\n"
                + "################################################\n"
                + "################################################\n"
                + "################################################\n",
                wallImg,
                areaImg,
                boxImg,
                "Joe",
                playerImg,
                ghostImg,
                zombieImg,
                boxImg,
                Board.ChallengeType.PLACEBOXES);

        TwoPlayerBoard level2 = new TwoPlayerBoard(
                "################################################\n"
                        + "################################################\n"
                        + "################################################\n"
                        + "################################################\n"
                        + "################################################\n"
                        + "#####   1          .  ######                ####\n"
                        + "###.   #       $ 1      ##               2   ###\n"
                        + "###     #         # #   ##   $$$$$$$ $$$$$   ###\n"
                        + "###. +         #  $     ##   $      $    $   ###\n"
                        + "###   #     #    #   #  ##   $ $      @  $   ###\n"
                        + "###.    #   #    #      ##   $$$$$$$ $$$$$   ###\n"
                        + "###         #  1    $   ##          2        ###\n"
                        + "####            #  #   ####                 ####\n"
                        + "################################################\n"
                        + "################################################\n"
                        + "################################################\n"
                        + "################################################\n",
                wallImg,
                areaImg,
                boxImg,
                "Joe",
                "Bloggs",
                playerImg,
                player2Img,
                ghostImg,
                zombieImg,
                boxImg,
                Board.ChallengeType.TRAPZOMBIES);

        board = level1;

        recreateAllSprites();

    }

    @Override
    public void render () {

        Gdx.gl.glClearColor(255/255f, 204/255f, 153/255f, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            //if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) //for different keyboard movement types???
            board.player.move(Direction.LEFT, board);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            board.player.move(Direction.RIGHT, board);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            board.player.move(Direction.DOWN, board);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            board.player.move(Direction.UP, board);
        }

//        if (board instanceof TwoPlayerBoard) {
//            if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
//                //if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) //for different keyboard movement types???
//                board.player2.move(Direction.LEFT, board);
//            }
//            if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
//                board.player2.move(Direction.RIGHT, board);
//            }
//            if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
//                board.player2.move(Direction.DOWN, board);
//            }
//            if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
//                board.player2.move(Direction.UP, board);
//            }
//        }

        if (TimeUtils.timeSinceNanos(startTime) > timeBetweenEnemyMoves) {
            if (timeBetweenEnemyMoves > 500000000) {
                timeBetweenEnemyMoves = timeBetweenEnemyMoves - 10000000;
            }

            board.enemiesMoveAll();
            startTime = TimeUtils.nanoTime();
        }

        recreateAllSprites();

        // render all sprites
        batch.begin();
        for (Sprite sprite : wallSprites) {
            sprite.draw(batch);
        }
        for (Sprite sprite : areaSprites) {
            sprite.draw(batch);
        }
        for (Sprite sprite : boxSprites) {
            sprite.draw(batch);
        }
        playerSprite.draw(batch);
        player2Sprite.draw(batch);
        for (Sprite sprite : enemySprites) {
            sprite.draw(batch);
        }
        batch.end();

        // Check if the game has ended
        if (board.checkWinCondition()) {
            //completeLevelSound.play(0.5f);
            dispose();
        } else if (board.checkLossCondition()) {
            dispose();
        }

    }

    @Override
    public void dispose () {
        batch.dispose();
        wallImg.dispose();
        areaImg.dispose();
        boxImg.dispose();
        playerImg.dispose();
        player2Img.dispose();
        ghostImg.dispose();
        gameSound.dispose();
    }

    // calculates where all the sprites are on the map
    private void recreateAllSprites() {

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        wallSprites = new ArrayList<Sprite>();
        boxSprites = new ArrayList<Sprite>();
        areaSprites = new ArrayList<Sprite>();
        enemySprites = new ArrayList<Sprite>();

        for (Wall wall : board.walls) {
            Sprite sprite = new Sprite(wall.getImage());
            sprite.setSize(w / board.width, h / board.height);
            float xPos = ((w * wall.getX())/board.width);
            float yPos = ((h * wall.getY())/board.height);
            sprite.setPosition(xPos, yPos);
            wallSprites.add(sprite);
        }
        for (Box box : board.boxes) {
            Sprite sprite = new Sprite(box.getImage());
            sprite.setSize(w / board.width, h / board.height);
            float xPos = ((w * box.getX())/board.width);
            float yPos = ((h * box.getY())/board.height);
            sprite.setPosition(xPos, yPos);
            boxSprites.add(sprite);
        }

        playerSprite = new Sprite(board.player.getImage());
        playerSprite.setSize(w / board.width, h / board.height);
        float xPos = ((w * board.player.getX())/board.width);
        float yPos = ((h * board.player.getY())/board.height);
        playerSprite.setPosition(xPos, yPos);

        if (board instanceof TwoPlayerBoard) {
            player2Sprite = new Sprite(board.player2.getImage());
            player2Sprite.setSize(w / board.width, h / board.height);
            float p2XPos = ((w * board.player2.getX())/board.width);
            float p2YPos = ((h * board.player2.getY())/board.height);
            player2Sprite.setPosition(p2XPos, p2YPos);
        }

        for (Enemy enemy : board.ghosts) {
            Sprite sprite = new Sprite(enemy.getImage());
            sprite.setSize(w / board.width, h / board.height);
            float eXPos = ((w * enemy.getX())/board.width);
            float eYPos = ((h * enemy.getY())/board.height);
            sprite.setPosition(eXPos, eYPos);
            enemySprites.add(sprite);
        }
        for (Enemy enemy : board.zombies) {
            Sprite sprite = new Sprite(enemy.getImage());
            sprite.setSize(w / board.width, h / board.height);
            float eXPos = ((w * enemy.getX())/board.width);
            float eYPos = ((h * enemy.getY())/board.height);
            sprite.setPosition(eXPos, eYPos);
            enemySprites.add(sprite);
        }

        for (Area area : board.areas) {
            Sprite sprite = new Sprite(area.getImage());
            sprite.setSize(w / board.width, h / board.height);
            float aXPos = ((w * area.getX())/board.width);
            float aYPos = ((h * area.getY())/board.height);
            sprite.setPosition(aXPos, aYPos);
            areaSprites.add(sprite);
        }
    }

}

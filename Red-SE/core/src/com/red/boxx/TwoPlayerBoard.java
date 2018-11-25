package com.red.boxx;

import com.badlogic.gdx.graphics.Texture;

public class TwoPlayerBoard extends Board {

    public Player player2;

    public TwoPlayerBoard(String map,
                 Texture wallImage,
                 Texture areaImage,
                 Texture boxImage,
                 String playerName,
                 String player2Name,
                 Texture playerImage,
                 Texture player2Image,
                 Texture ghostImage,
                 Texture zombieImage,
                 Texture bombBoxImage,
                 ChallengeType challenge) {

        super(map,
            wallImage,
            areaImage,
            boxImage,
            playerName,
            playerImage,
            ghostImage,
            zombieImage,
            bombBoxImage,
            challenge);


        logger.log(Logger.LoggingType.DEBUG, "boxWallOrBoxCollisions",
                "Creating a two player board with the source file: " + map);

        int scanCreatorX = 0;
        int scanCreatorY = 0;

        String level = map;         // Hardcoded map at moment, later on we read .tmx files for the map

        // Scans the map, and places objects on the Game Board.
        for (int i = 0; i < level.length(); i++) {
            char item = level.charAt(i);

            switch (item) {

                case '\n':
                    scanCreatorY += 1;
                    scanCreatorX = 0;
                    break;

                case '+':
                    this.player2 = new Player(player2Name, scanCreatorX, scanCreatorY, player2Image);
                    scanCreatorX += 1;
                    break;

                default:
                    scanCreatorX += 1;
                    break;
            }

        }

        System.out.println("Pos: " + player2.getX());

    }

    @Override
    public boolean checkLossCondition() {
        for (Enemy enemy : this.ghosts) {
            if (enemy.getX() == player.getX() && enemy.getY() == player.getY()) {
                return true;
            }
        }
        for (Enemy enemy : this.zombies) {
            if (enemy.getX() == player.getX() && enemy.getY() == player.getY()) {
                return true;
            }
        }

        for (Enemy enemy : this.ghosts) {
            if (enemy.getX() == player2.getX() && enemy.getY() == player2.getY()) {
                return true;
            }
        }
        for (Enemy enemy : this.zombies) {
            if (enemy.getX() == player2.getX() && enemy.getY() == player2.getY()) {
                return true;
            }
        }
        return false;
    }

}

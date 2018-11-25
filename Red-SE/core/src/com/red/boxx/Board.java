package com.red.boxx;
import java.util.ArrayList;
import com.badlogic.gdx.graphics.Texture;
import java.util.Random;

// This is where the main game logic goes
public class Board {

    // TODO: Should all of these be private with getters?
    public ArrayList<Wall> walls = new ArrayList<Wall>();
    public ArrayList<Box> boxes = new ArrayList<Box>();
    public ArrayList<BombBox> bombBoxes = new ArrayList<BombBox>();
    public ArrayList<Area> areas = new ArrayList<Area>();
    public ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
    public ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    public Player player;
    public ChallengeType challenge;

    public int width;
    public int height;

    public static Logger logger = new Logger(true);

    public Board(String map,
                 Texture wallImage,
                 Texture areaImage,
                 Texture boxImage,
                 String playerName,
                 Texture playerImage,
                 Texture ghostImage,
                 Texture zombieImage,
                 Texture bombBoxImage,
                 ChallengeType challenge) {

        logger.log(Logger.LoggingType.DEBUG, "boxWallOrBoxCollisions",
                "Creating a board with the source file: " + map);

        this.challenge = challenge;

        int scanCreatorX = 0;
        int scanCreatorY = 0;
        Wall tempWall;
        Box tempBox;
        Area tempArea;
        Ghost tempGhost;
        Zombie tempZombie;
        BombBox tempBombBox;

        // TODO: Check that the extension of the map is .tmx

        // TODO: Read in the map from the text file and build a simple text string
        String level = map;         // Hardcoded map at moment, later on we read .tmx files for the map

        // Scans the map, and places objects on the Game Board.
        for (int i = 0; i < level.length(); i++) {
            char item = level.charAt(i);

            switch (item) {

                case '\n':
                    scanCreatorY += 1;
                    if (this.getWidth() < scanCreatorX) {
                        this.setWidth(scanCreatorX);
                    }
                    scanCreatorX = 0;
                    break;

                case '#':
                    tempWall = new Wall(scanCreatorX, scanCreatorY, wallImage);
                    walls.add(tempWall);
                    scanCreatorX += 1;
                    break;

                case '$':
                    tempBox = new Box(scanCreatorX, scanCreatorY, boxImage);
                    boxes.add(tempBox);
                    scanCreatorX += 1;
                    break;

                case '%':
                    tempBombBox = new BombBox(scanCreatorX, scanCreatorY, boxImage);
                    boxes.add(tempBombBox);
                    scanCreatorX += 1;
                    break;

                case '.':

                    tempArea = new Area(scanCreatorX, scanCreatorY, areaImage);
                    areas.add(tempArea);
                    scanCreatorX += 1;
                    break;

                case '@':
                    this.player = new Player(playerName, scanCreatorX, scanCreatorY, playerImage);
                    scanCreatorX += 1;
                    break;

                case '+':
                    scanCreatorX += 1;
                    break;

                case '1':
                    tempGhost = new Ghost(scanCreatorX, scanCreatorY, ghostImage);
                    ghosts.add(tempGhost);
                    scanCreatorX += 1;
                    break;

                case '2':
                    tempZombie = new Zombie(scanCreatorX, scanCreatorY, zombieImage);
                    zombies.add(tempZombie);
                    scanCreatorX += 1;
                    break;

                case ' ':
                    scanCreatorX += 1;
                    break;

                default:
                    break;
            }

            setHeight(scanCreatorY);
        }

        logger.log(Logger.LoggingType.DEBUG, "BoardLog",
                "Created board with WIDTH " + getWidth() + " and HEIGHT " + getHeight() + ".");

    }

    public void enemiesMoveAll() {
        for (Ghost e : ghosts) {
            e.moveRandom(this);
        }
        for (Zombie e : zombies) {
            e.moveRandom(this);
        }
    }

    public boolean checkWinCondition() {

        if(this.challenge == ChallengeType.TRAPZOMBIES) {
            int zombieCnt = this.zombies.size();
            int trappedZombies = 0;
            for (Zombie zombie : this.zombies) {
                if (!zombie.canMove(this)) {
                    trappedZombies++;
                }
            }
            return trappedZombies == zombieCnt;
        } else /* if (this.challenge == ChallengeType.PLACEBOXES) */ {
            int boxCnt = this.boxes.size();
            int completedBoxes = 0;
            for (Box box : this.boxes) {
                for (Area area : this.areas) {
                    if (box.getX() == area.getX() && box.getY() == area.getY()) {
                        completedBoxes++;
                    }
                }
            }
            return completedBoxes == boxCnt;
        }

    }

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
        return false;
    }


    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public enum ChallengeType {
        TRAPZOMBIES,
        PLACEBOXES
    }

}

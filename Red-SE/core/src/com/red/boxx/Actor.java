package com.red.boxx;
import com.badlogic.gdx.graphics.Texture;


// An actor is any entity that exists on the map.
public class Actor {

    // It has an x/y location
    private int x;
    private int y;

    //  This is what it looks like
    private Texture image;

    // The constructor for the Actor
    public Actor(int x, int y, Texture image) {
        this.setX(x);
        this.setY(y);
        setImage(image);
    }

    public Texture getImage() {
        return image;
    }

    public void setImage(Texture image) {
        this.image = image;
    }

    // Getters and Setters
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    // Dealing with Actor collision
    public boolean isLeftCollision(Actor actor) {
        return this.getX() - 1 == actor.getX() && this.getY() == actor.getY();
    }

    public boolean isRightCollision(Actor actor) {
        return this.getX() + 1 == actor.getX() && this.getY() == actor.getY();
    }

    public boolean isTopCollision(Actor actor) {
        return this.getX() == actor.getX() && this.getY() - 1 == actor.getY();
    }

    public boolean isBottomCollision(Actor actor) {
        return this.getX() == actor.getX() && this.getY() + 1 == actor.getY();
    }

    public boolean wallCollisions(Direction direction, Board board) {

        Board.logger.log(Logger.LoggingType.DEBUG, "wallCollisions",
                "Checking whether the actor is colliding with a wall...");

        if (direction == Direction.LEFT) {
            for (Wall wall : board.walls) {
                if (this.isLeftCollision(wall)) {
                    Board.logger.log(Logger.LoggingType.DEBUG, "wallCollisions",
                            "There's a wall to the LEFT of the actor, returning.");
                    return true;
                }
            }
            return false;
        } else if (direction == Direction.RIGHT) {
            for (Wall wall : board.walls) {
                if (this.isRightCollision(wall)) {
                    Board.logger.log(Logger.LoggingType.DEBUG, "wallCollisions",
                            "There's a wall to the RIGHT of the actor, returning.");
                    return true;
                }
            }
            return false;
        } else if (direction == Direction.UP) {
            for (Wall wall : board.walls) {
                if (this.isTopCollision(wall)) {
                    Board.logger.log(Logger.LoggingType.DEBUG, "wallCollisions",
                            "There's a wall to the TOP of the actor, returning.");
                    return true;
                }
            }
            return false;
        } else /* if (dir == Direction.DOWN) */ {
            for (Wall wall : board.walls) {
                if (this.isBottomCollision(wall)) {
                    Board.logger.log(Logger.LoggingType.DEBUG, "wallCollisions",
                            "There's a wall to the BOTTOM of the actor, returning.");
                    return true;
                }
            }
            Board.logger.log(Logger.LoggingType.DEBUG, "wallCollisions",
                    "There are no walls blocking the actor, returning.");
            return false;
        }

    }

    public boolean boxCollisions(Direction direction, Board board) {

        Board.logger.log(Logger.LoggingType.DEBUG, "boxCollisions",
                "Checking whether the actor is colliding with a box...");

        if (direction == Direction.LEFT) {
            for (Box box : board.boxes) {
                if (this.isLeftCollision(box)) {
                    Board.logger.log(Logger.LoggingType.DEBUG, "boxCollisions",
                            "There is a box to the LEFT of the actor...");
                    return true;
                }
            }
            return false;
        } else if (direction == Direction.RIGHT) {
            for (Box box : board.boxes) {
                if (this.isRightCollision(box)) {
                    Board.logger.log(Logger.LoggingType.DEBUG, "boxCollisions",
                            "There is a box to the RIGHT of the actor...");
                    return true;
                }
            }
            return false;
        } else if (direction == Direction.UP) {
            for (Box box : board.boxes) {
                if (this.isTopCollision(box)) {
                    Board.logger.log(Logger.LoggingType.DEBUG, "boxCollisions",
                            "There is a box to the TOP of the actor...");
                    return true;
                }
            }
            return false;
        } else /* if (dir == Direction.DOWN) */ {
            for (Box box : board.boxes) {
                if (this.isBottomCollision(box)) {
                    Board.logger.log(Logger.LoggingType.DEBUG, "boxCollisions",
                            "There is a box to the BOTTOM of the actor...");
                    return true;
                }
            }
            Board.logger.log(Logger.LoggingType.DEBUG, "boxCollisions",
                    "There are no boxes blocking the actor, returning.");
            return false;
        }

    }

    public boolean playerCollisions(Direction direction, Board board) {

        Board.logger.log(Logger.LoggingType.DEBUG, "playerCollisions",
                "Checking whether the actor is colliding with a player...");

        if (direction == Direction.LEFT) {
            if (this.isLeftCollision(board.player)) {
                Board.logger.log(Logger.LoggingType.DEBUG, "playerCollisions",
                        "There is a player to the LEFT of the actor...");
                return true;
            }
            return false;
        } else if (direction == Direction.RIGHT) {
            if (this.isRightCollision(board.player)) {
                Board.logger.log(Logger.LoggingType.DEBUG, "playerCollisions",
                        "There is a player to the RIGHT of the actor...");
                return true;
            }
            return false;
        } else if (direction == Direction.UP) {
            if (this.isTopCollision(board.player)) {
                Board.logger.log(Logger.LoggingType.DEBUG, "playerCollisions",
                        "There is a player to the TOP of the actor...");
                return true;
            }
            return false;
        } else /* if (dir == Direction.DOWN) */ {
            if (this.isBottomCollision(board.player)) {
                Board.logger.log(Logger.LoggingType.DEBUG, "playerCollisions",
                        "There is a player to the BOTTOM of the actor...");
                return true;
            }
            Board.logger.log(Logger.LoggingType.DEBUG, "playerCollisions",
                    "There are no players blocking the actor, returning.");
            return false;
        }

    }

    public boolean player2Collisions(Direction direction, TwoPlayerBoard board) {

        Board.logger.log(Logger.LoggingType.DEBUG, "player2Collisions",
                "Checking whether the actor is colliding with a player...");

        if (direction == Direction.LEFT) {
            if (this.isLeftCollision(board.player2)) {
                Board.logger.log(Logger.LoggingType.DEBUG, "player2Collisions",
                        "There is a player to the LEFT of the actor...");
                return true;
            }
            return false;
        } else if (direction == Direction.RIGHT) {
            if (this.isRightCollision(board.player2)) {
                Board.logger.log(Logger.LoggingType.DEBUG, "player2Collisions",
                        "There is a player to the RIGHT of the actor...");
                return true;
            }
            return false;
        } else if (direction == Direction.UP) {
            if (this.isTopCollision(board.player2)) {
                Board.logger.log(Logger.LoggingType.DEBUG, "player2Collisions",
                        "There is a player to the TOP of the actor...");
                return true;
            }
            return false;
        } else /* if (dir == Direction.DOWN) */ {
            if (this.isBottomCollision(board.player2)) {
                Board.logger.log(Logger.LoggingType.DEBUG, "player2Collisions",
                        "There is a player to the BOTTOM of the actor...");
                return true;
            }
            Board.logger.log(Logger.LoggingType.DEBUG, "player2Collisions",
                    "There are no players blocking the actor, returning.");
            return false;
        }

    }

    public boolean zombieCollisions(Direction direction, Board board) {

        Board.logger.log(Logger.LoggingType.DEBUG, "zombieCollisions",
                "Checking whether the actor is colliding with a zombie...");

        if (direction == Direction.LEFT) {
            for (Zombie zombie : board.zombies) {
                if (this.isLeftCollision(zombie)) {
                    Board.logger.log(Logger.LoggingType.DEBUG, "zombieCollisions",
                            "There is a zombie to the LEFT of the actor...");
                    return true;
                }
            }
            return false;
        } else if (direction == Direction.RIGHT) {
            for (Zombie zombie : board.zombies) {
                if (this.isRightCollision(zombie)) {
                    Board.logger.log(Logger.LoggingType.DEBUG, "zombieCollisions",
                            "There is a zombie to the RIGHT of the actor...");
                    return true;
                }
            }
            return false;
        } else if (direction == Direction.UP) {
            for (Zombie zombie : board.zombies) {
                if (this.isTopCollision(zombie)) {
                    Board.logger.log(Logger.LoggingType.DEBUG, "zombieCollisions",
                            "There is a zombie to the TOP of the actor...");
                    return true;
                }
            }
            return false;
        } else /* if (dir == Direction.DOWN) */ {
            for (Zombie zombie : board.zombies) {
                if (this.isBottomCollision(zombie)) {
                    Board.logger.log(Logger.LoggingType.DEBUG, "zombieCollisions",
                            "There is a zombie to the BOTTOM of the actor...");
                    return true;
                }
            }
            Board.logger.log(Logger.LoggingType.DEBUG, "zombieCollisions",
                    "There are no zombies blocking the actor, returning.");
            return false;
        }

    }

}

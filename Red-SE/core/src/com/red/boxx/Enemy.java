package com.red.boxx;

import com.badlogic.gdx.graphics.Texture;

public class Enemy extends Actor {

    public Enemy(int startingX, int startingY, Texture image) {
        super(startingX, startingY, image);

        initEnemy();
    }

    private void initEnemy() {

    }

    public void move(int xDisplacement, int yDisplacement) {
        int newX = getX() + xDisplacement;
        int newY = getY() + yDisplacement;

        setX(newX);
        setY(newY);
    }
}

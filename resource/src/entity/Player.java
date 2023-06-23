package entity;

import javax.swing.*;

public class Player implements Movement{
    private int X, Y;

    public Player(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    @Override
    public ImageIcon upAndDown(boolean isUp) {
        return new ImageIcon(isUp ? "src/assets/charup.gif" : "src/assets/chardown.gif");
    }

    @Override
    public ImageIcon leftAndRight(boolean isLeft) {
        return new ImageIcon(isLeft ? "src/assets/charleft.gif" : "src/assets/charright.gif");
    }
}

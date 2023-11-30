package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    private int r;
    private int x,y;
    private Color col;
    private int xfactor, yfactor;
    private int speed;

    public Ball(int x, int y, int r,int xfactor, int yfactor, Color c, int speed){
        this.x=x;
        this.y=y;
        this.r=r;
        this.xfactor=xfactor;
        this.yfactor=yfactor;
        this.speed = speed;
        col=c;
    }
    public void draw(ShapeRenderer sr){
        sr.setColor(col);
        sr.circle(x,y,r);
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR(){
        return r;
    }

    public Color getCol() {
        return col;
    }

    public void setCol(Color col) {
        this.col = col;
    }
    public int getXfactor(){
        return xfactor;
    }
    public void setXfactor(int xfactor){
        this.xfactor = xfactor;
    }
    public int getYfactor(){
        return yfactor;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setYfactor(int yfactor){
        this.yfactor = yfactor;
    }
}
package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import java.security.SecureRandom;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
public class MyGdxGame extends ApplicationAdapter {

    ShapeRenderer sr;
    SecureRandom rand;
    Paddle lpad;
    Paddle rpad;
    Ball ball;
    public SpriteBatch batch;
    public BitmapFont font;


    @Override
    public void create() {
        sr = new ShapeRenderer();
        rand = new SecureRandom();
        lpad = new Paddle(0, Gdx.graphics.getHeight() / 2, 10, 75, 'v', Color.BLUE);
        rpad = new Paddle(790, Gdx.graphics.getHeight() / 2, 10, 75, 'v', Color.RED);
        ball = new Ball(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 10, 5, 5, Color.WHITE, -2);
        batch = new SpriteBatch();
        font = new BitmapFont();
    }


    @Override
    public void render() {

        paddleMovement(10);
        ballMovement(2);
        super.render();
        ScreenUtils.clear(0, 0, 0, 1);
        sr.begin(ShapeRenderer.ShapeType.Filled);
        lpad.draw(sr);
        rpad.draw(sr);
        ball.draw(sr);
        batch.begin();
        font.draw(batch, "Welcome to Drop!!! ", 100, 150);
        font.draw(batch, "Tap anywhere to begin!", 100, 100);
        batch.end();
        sr.end();

    }

    public void paddleMovement(int d) {
        if (Gdx.input.isKeyPressed(Input.Keys.W) && (lpad.getY() < Gdx.graphics.getHeight() - 75)) {
            lpad.setY(lpad.getY() + d);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S) && (lpad.getY() > 0)) {
            lpad.setY(lpad.getY() - d);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP) && (rpad.getY() < Gdx.graphics.getHeight() - 75)) {
            rpad.setY(rpad.getY() + d);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && (rpad.getY() > 0)) {
            rpad.setY(rpad.getY() - d);
        }
    }

    public void ballMovement(int velocity) {
        ball.setX(ball.getX() + ball.getXfactor());
        ball.setY(ball.getY() + ball.getYfactor());

        //screen collision
        if (ball.getY() + ball.getR() > Gdx.graphics.getHeight()) {
            ball.setYfactor(-(ball.getYfactor()));
        }
        if (ball.getY() - ball.getR() < 0) {
            ball.setYfactor(-(ball.getYfactor()));
        }
        //paddle collision

        if (lpad.getX() - ball.getR() > ball.getX() && lpad.getX() < ball.getX() + lpad.getW()) {
            if (lpad.getY() > ball.getY() && lpad.getY() < ball.getY() - ball.getR()) {
                ball.setXfactor(-(ball.getXfactor()));
            }
        }
        if (ball.getX() < lpad.getX() + lpad.getW() && ball.getX() < lpad.getX() + lpad.getW()) {
            if (ball.getY() > lpad.getY() && ball.getY() < lpad.getY() + lpad.getH() - lpad.getW()) {
                ball.setXfactor(-(ball.getXfactor()));
            }
        }

        if (rpad.getX() > ball.getX() && rpad.getX() < ball.getX() + rpad.getW()) {
            if (rpad.getY() > ball.getY() && rpad.getY() < ball.getY() + ball.getR()) {
                ball.setXfactor(-(ball.getXfactor()));
            }
        }
        if (ball.getX() > rpad.getX() && ball.getX() < rpad.getX() + rpad.getW()) {
            if (ball.getY() > rpad.getY() && ball.getY() < rpad.getY() + rpad.getH()) {
                ball.setXfactor(-(ball.getXfactor()));
            }
        }
        //game ending
        if(ball.getX() > Gdx.graphics.getWidth() + 20){
            ball.setX(Gdx.graphics.getWidth()/2);
            ball.setY(Gdx.graphics.getHeight()/2);
        }
        if(ball.getX() < -20){
            ball.setX(Gdx.graphics.getWidth()/2);
            ball.setY(Gdx.graphics.getHeight()/2);
        }

    }


    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
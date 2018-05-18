package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by oqwid on 13.12.2017.
 */

public class Tube {

    public static final int TUBE_WIDTH = 52;

    private Cosm cosm;

    private boolean isScored = false;
    private int scor = 0;





    public static final int FLUCTUATION = 135;//=130 изначально было
    public static final int TUBE_GAP = 125;//=100 изначально было || это расстояние между трубами
    public static final int LOWEST_OPENING = 130;//120 было

    private Texture bottomTube, topTube;
    private Vector2 posTopTube, posBotTube;
    private Random rand;

    private Rectangle boundsTop, boundsBot;

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Texture getTopTube() {

        return topTube;
    }

    public Vector2 getPosTopTube() {

        return posTopTube;
    }

    public Vector2 getPosBotTube() {

        return posBotTube;
    }

    public Tube (float x){
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        rand = new Random();



        posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight()+1000000);
        boundsBot = new Rectangle(posBotTube.x, posBotTube.y, bottomTube.getWidth(), bottomTube.getHeight());
    }

    public void reposition(float x){
        posTopTube.set(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
        boundsTop.setPosition(posTopTube.x, posTopTube.y);
        boundsBot.setPosition(posBotTube.x, posBotTube.y);
    }

    public boolean isScored() {
        return isScored;
    }

    public void setScored(boolean b) {
        isScored = b;
        addScore(1);
    }



    public int getScore(){
        return scor;
    }
    private void addScore(int increment){
        scor += increment;

    }

    public boolean collides (Rectangle player){

        if (getPosTopTube().x < 72) {
            addScore(1);
            this.setScored(false);
        }

        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }

    public void dispose() {
        topTube.dispose();
        bottomTube.dispose();
    }
}

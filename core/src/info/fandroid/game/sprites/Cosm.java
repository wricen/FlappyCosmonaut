package info.fandroid.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by oqwid on 10.12.2017.
 */

public class Cosm {
    private static final int MOVEMENT = 95;
    private static final int GRAVITY = 12;
    public static String getScore;
    private Vector3 position;
    private Vector3 velosity;
    private Rectangle bounds;






    private Sound flap;

    private Texture texture;
    private Animation cosmAnimation;

    public Cosm (int x, int y){
        position = new Vector3 (x,y,0);
        velosity = new Vector3(0,0,0);

        texture = new Texture("cosmanimation.png");
        cosmAnimation = new Animation(new TextureRegion(texture), 3, 0.5f);
        bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight());
        flap = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }


    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getCosm() {
        return cosmAnimation.getFrame();
    }

    public void update (float dt){
        cosmAnimation.update(dt);
        if (position.y > 0)
            velosity.add(0, GRAVITY, 0);
        velosity.scl(dt);
        position.add(MOVEMENT * dt, velosity.y, 0);
        if (position.y < 0)
            position.y = 0;




        velosity.scl(1/dt);
        bounds.setPosition(position.x, position.y);

    }

    public void jump(){
        velosity.y = -250;
        flap.play();

    }

    public Rectangle getBounds(){
        return bounds;
    }




    public void dispose() {
        texture.dispose();
        flap.dispose();
    }
}

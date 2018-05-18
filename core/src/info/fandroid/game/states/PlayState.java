package info.fandroid.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import info.fandroid.game.FlappyDemo;
import info.fandroid.game.sprites.Cosm;
import info.fandroid.game.sprites.Tube;
/**
 * Created by oqwid on 10.12.2017.
 */

public class PlayState extends State {

    private static final int TUBE_SPACING = 140; //расстояние между появл трубами
    private static final int TUBE_COUNT = 4;//4 комплекта труб
    private static final int GROUND_Y_OFFSET = 0; //задали координату игрек для граунда



    private Cosm cosm;
    private Texture bg;
    private Texture ground;
    private Vector2 groundPos1, groundPos2;

    private int bestScore = 0;
    private int score = -1;

    public Tube tube;

    public Array<Tube> tubes;

    String scor;



    public PlayState(GameStateManager gsm) {
        super(gsm);
        cosm = new Cosm (50, 150);
        camera.setToOrtho(false, FlappyDemo.WIDHT/2, FlappyDemo.HEIGHT/2);
        bg = new Texture("bg.png");
        ground = new Texture("ground.png");
        groundPos1 = new Vector2(camera.position.x - camera.viewportWidth / 2, GROUND_Y_OFFSET);
        groundPos2 = new Vector2((camera.position.x - camera.viewportWidth / 2) + ground.getWidth(), GROUND_Y_OFFSET);

        tubes = new Array<Tube>();

        for (int i=0; i<TUBE_COUNT; i++){
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
            tubes.get(i).setScored(false);
        }

    }


    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched())
        cosm.jump();
    }

    @Override
    public void update(float dt) {
        handleInput();
        cosm.update(dt);
        updateGround();
        camera.position.x = cosm.getPosition().x + 80;

        for (int i =0; i< tubes.size; i++){

            Tube tube = tubes.get(i);



            if (camera.position.x - (camera.viewportWidth / 2) > tube.getPosTopTube().x
                    + tube.getTopTube().getWidth()){
                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
                addScore();
            }




            if (tube.collides(cosm.getBounds())) {
                gsm.set(new GameOver(gsm, score));
            }

        }
        camera.update();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(bg, camera.position.x - (camera.viewportWidth / 2), 0);
        sb.draw(ground, groundPos1.x, groundPos1.y);
        sb.draw(ground, groundPos2.x, groundPos2.y);
        for (Tube tube : tubes) {
            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }
        sb.draw(cosm.getCosm(),cosm.getPosition().x,cosm.getPosition().y);

        if (score >= 0) {
            FlappyDemo.shadow.draw(sb, "Your score: " + score, camera.position.x - camera.viewportWidth/4, camera.position.y + 4*camera.viewportHeight/9);
            FlappyDemo.font.draw(sb, "Your score: " + score, camera.position.x - camera.viewportWidth/4, camera.position.y + 4*camera.viewportHeight/9-1);
        }


        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        cosm.dispose();
        ground.dispose();
        for (Tube tube : tubes)
            tube.dispose();
    }

    private void updateGround(){
        if (camera.position.x - (camera.viewportWidth / 2) > groundPos1.x + ground.getWidth())
            groundPos1.add(ground.getWidth() * 2, 0);
        if (camera.position.x - (camera.viewportWidth / 2) > groundPos2.x + ground.getWidth())
            groundPos2.add(ground.getWidth() * 2, 0);
    }

    private void addScore() {
        score += 1;
    }

    private int getScore() {
        return score;
    }
}

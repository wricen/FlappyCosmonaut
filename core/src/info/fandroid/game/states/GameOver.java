package info.fandroid.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import info.fandroid.game.FlappyDemo;
import info.fandroid.game.Model;

/**
 * Created by oqwid on 10.12.2017.
 */

public class GameOver extends State {

    private Texture background;
    private Texture gameover;
    private Model mModel;

    private String highScore;

    public GameOver(GameStateManager gsm, int score) {
        super(gsm);
        camera.setToOrtho(false, FlappyDemo.WIDHT / 2, FlappyDemo.HEIGHT /2);
        background = new Texture("bg.png");
        gameover = new Texture("gameover.png");
        mModel = new Model();
        mModel.setHighScore(score);
        highScore = String.valueOf(mModel.getHighScore());
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()
                ) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
    handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
    sb.begin();
    sb.setProjectionMatrix(camera.combined);
    sb.draw(background, 0,0);
    sb.draw(gameover, camera.position.x - gameover.getWidth() / 2, camera.position.y - gameover.getHeight() /2);
    FlappyDemo.shadow.draw(sb, "The best score: " + highScore, camera.position.x + 6*FlappyDemo.shadow.getXHeight()  , camera.position.y+gameover.getHeight()*2);
    FlappyDemo.font.draw(sb, "The best score: "+ highScore, camera.position.x + 6*FlappyDemo.shadow.getXHeight()  , camera.position.y +gameover.getHeight()*2-1);
    //FlappyDemo.shadow.draw(sb, "tap to retry", camera.position.x - gameover.getWidth()/4 - gameover.getWidth()/16 , camera.position.y - 2*gameover.getHeight()/3);
    //FlappyDemo.font.draw(sb, "tap to retry", camera.position.x-gameover.getWidth()/4 - gameover.getWidth()/16, camera.position.y - 2*gameover.getHeight()/3 - 1);


    FlappyDemo.shadow.draw(sb, "tap to retry", camera.position.x + 4*FlappyDemo.shadow.getXHeight() , camera.position.y - 3*gameover.getHeight()/2);
    FlappyDemo.font.draw(sb, "tap to retry", camera.position.x + 4*FlappyDemo.shadow.getXHeight(), camera.position.y - 3*gameover.getHeight()/2 - 1);


        sb.end();
    }

    @Override
    public void dispose() {
    background.dispose();
    gameover.dispose();

    }
}

package info.fandroid.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import info.fandroid.game.FlappyDemo;

/**
 * Created by oqwid on 10.12.2017.
 */

public class MenuState extends State {

    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, FlappyDemo.WIDHT / 2, FlappyDemo.HEIGHT /2);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
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
    sb.draw(playBtn, camera.position.x - playBtn.getWidth() / 2, camera.position.y - playBtn.getHeight() /2);
        FlappyDemo.shadow.draw(sb, "FLAPPY COSMONAUT", 0 + camera.viewportWidth /6 , camera.position.y + camera.viewportHeight/4);
        FlappyDemo.font.draw(sb, "FLAPPY COSMONAUT", 0 + camera.viewportWidth/6, camera.position.y + camera.viewportHeight/4-1);

        FlappyDemo.shadow.draw(sb, "tap to continue", 0 + camera.viewportWidth /5 , camera.position.y - camera.viewportHeight/6);
        FlappyDemo.font.draw(sb, "tap to continue", 0 + camera.viewportWidth/5, camera.position.y - camera.viewportHeight/6-1);


        sb.end();
    }

    @Override
    public void dispose() {
    background.dispose();
    playBtn.dispose();

    }
}

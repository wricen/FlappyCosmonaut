package info.fandroid.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import info.fandroid.game.states.GameStateManager;
import info.fandroid.game.states.MenuState;

public class FlappyDemo extends ApplicationAdapter {
	public static final int  WIDHT = 480;
	public static final int  HEIGHT = 800;
	public static final String TITLE = "Flappy Demo";


	public static BitmapFont font, shadow;


	private GameStateManager gsm;
	private SpriteBatch batch;
	private Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);//бесконечный повтор воспроизведения
		music.setVolume(0.1f);
		music.play();
		Gdx.gl.glClearColor(1, 0, 0, 1);
        gsm.push(new MenuState(gsm));


		font = new BitmapFont(Gdx.files.internal("text1.fnt"),
				Gdx.files.internal("text.png"), true);
		font.getData().setScale(.25f,-.25f);

		shadow = new BitmapFont(Gdx.files.internal("shadow1.fnt"),
				Gdx.files.internal("shadow.png"), true);
		shadow.getData().setScale(.25f,-.25f);

	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());//возравщает время между последним и текущим кадром
		gsm.render(batch);

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		super.dispose();
		music.dispose();

	}
}

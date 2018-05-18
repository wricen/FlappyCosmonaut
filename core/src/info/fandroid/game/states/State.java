package info.fandroid.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by oqwid on 10.12.2017.
 */

public abstract class State {

    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    public State (GameStateManager gsm)
    {
        this.gsm = gsm;
        camera = new OrthographicCamera();
        mouse = new Vector3();

    }

    protected abstract void handleInput(); //реагирует на нажатие на экран или кнопки
    public abstract void update(float dt); //перемещает экран, обновляя картинку через одинаковое время
    public abstract void render (SpriteBatch sb); //отрисовка экрана в координатах
    public abstract void dispose(); //удаляет ненужный экземпляр класса



}

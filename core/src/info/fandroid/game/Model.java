package info.fandroid.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


/**
 * Created by oqwid on 12.05.2018.
 */

public class Model {
    Preferences prefs = Gdx.app.getPreferences("highScore");

    public Model() {
    }

    public int getHighScore() {
        return prefs.getInteger("highScore");
    }

    public void setHighScore(int highScore) {
        if (highScore > prefs.getInteger("highScore")) {
            prefs.putInteger("highScore", highScore);
            prefs.flush();
        }
    }
}

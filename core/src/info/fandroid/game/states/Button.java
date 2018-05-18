package info.fandroid.game.states;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import info.fandroid.game.FlappyDemo;

/**
 * Created by oqwid on 14.05.2018.
 */

public class Button {


    private Button infoBtn;
    private Button playBtn;
    private Button replayBtn;
    private Button exitBtn;
    private Button pauseBtn;


    public Button(String info, TextButton.TextButtonStyle textButtonStyle){
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = FlappyDemo.font;



        infoBtn = new Button("INFO", textButtonStyle);
        Gdx.app.addLifecycleListener(new ClickListener(infoBtn));
        playBtn = new Button("PLAY", textButtonStyle);
        replayBtn = new Button("REPLAY", textButtonStyle);
        exitBtn = new Button("EXIT", textButtonStyle);
        exitBtn.
        pauseBtn = new Button("PAUSE", textButtonStyle);

    }



    public boolean touchDown (InputEvent evt, float x, float y, int pointer, int button){
            Gdx.input.vibrate(10);
            return true;
    };

    protected void replay(){

    }
    protected void play(){

    }
    protected void inf(){

    }
    protected void pause(){
        if(Gdx.input.isButtonPressed(pauseBtn)){
            Gdx.app.
        }
    }

    protected void exitGame(){
        if (Gdx.input.isButtonPressed(exitBtn){
            Gdx.app.exit();
        }

    }


}

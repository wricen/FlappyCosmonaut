package info.fandroid.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by oqwid on 10.12.2017.
 */

public class GameStateManager {

    private Stack<State> states;

    public GameStateManager()//подкласс класса вектор, последний вошел - первый вышел
    {
        states = new Stack<State>();//создает пустой стек
    }

    public void push(State state)//метод помещает элемент в верхушку стека
    {
        states.push(state);
    }

    public void pop()//забирает из стека верхний элемент, а затем удаляет оттуда
    {
        states.pop().dispose();
    }

    public void set (State state)//очищает верхний экран
    {
        states.pop().dispose();
        states.push(state);//здесь помещает следующий экран в вершину стека
    }

    public void update(float dt)//обновляет через равное время
    {
        states.peek().update(dt);//возвращает верхний элемент, не удаляя из стека
    }

    public void render(SpriteBatch sb)
    {
        states.peek().render(sb);//забирает верхнее состояние из стека, отрисовывает его
    }

}

package states;

import java.awt.*;
import main.StateManager;
import static java.lang.Thread.sleep;

public class MenuState extends State {
    @Override
    public void init() {

    }
    @Override
    public void update() {
        StateManager.getInstance().setState(StateManager.ORIGINALGAME);
    }
    @Override
    public void render(Graphics g) {


    }
}

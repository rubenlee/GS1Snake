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
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StateManager.getInstance().setState(StateManager.ORIGINALGAME);
    }
    @Override
    public void render(Graphics g) {


    }
}

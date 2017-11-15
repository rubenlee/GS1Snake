import java.awt.*;

public abstract class State {
    public abstract void init();

    public abstract void update();

    public abstract void render(Graphics g);

}

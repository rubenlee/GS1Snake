package entities;

import java.awt.*;

public abstract class Entity {
    public int x;
    public int y;
    public Entity(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void init(){

    }
    public abstract void update();
    public abstract void  render(Graphics g);
}

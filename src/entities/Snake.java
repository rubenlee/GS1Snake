package entities;

import java.awt.*;

public class Snake extends Entity {
    public int width;
    public int height;
    public boolean turn;
    public Color color;


    public Snake(int x, int y,int width,int height) {
        super(x, y);
        this.height=height;
        this.width=width;
    }

    @Override
    public void init(){
        turn = false;
        color = Color.BLUE;
    }

    @Override
    public void update() {
        if(x>=100){
            turn = true;
        }
        if(x<0){
            turn = false;
        }
        if(turn){
            x--;
            color = Color.RED;
        }else{
            x++;
            color = Color.BLUE;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }
}

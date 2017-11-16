package entities;

import main.InputManager;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Snake extends Entity {
    private Logger logger;
    public int width;
    public int height;
    public boolean turn;
    public Color color;
    private InputManager input;

    public Snake(int x, int y,int width,int height) {
        super(x, y);
        logger = Logger.getLogger(getClass().getName());

        this.height=height;
        this.width=width;
    }

    @Override
    public void init(){
        turn = false;
        color = Color.BLUE;
        input = InputManager.getInstance();
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

        if(input.isPressed("UP")){
            y--;
        }
        if(input.isPressed("DOWN")){
            y++;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }
}

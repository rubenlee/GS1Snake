package entities;

import com.sun.management.VMOption;
import main.DisplayManager;
import states.OriginalGameState;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Food extends Entity {
    private Logger logger;
    private Color color;
    private int cellWidth;
    private boolean hasCollide;

    public Food(int x, int y,int cellWidth){
        super(x,y);
        logger = Logger.getLogger(getClass().getName());
        this.cellWidth = cellWidth;
    }

    @Override
    public void init(){
        hasCollide=false;
        color = Color.GREEN;
        logger.log(Level.INFO, String.valueOf(x) + " " + String.valueOf(y));
    }

    @Override
    public void update(){
        if(hasCollide) {
            Point p = OriginalGameState.getRandomPosition();
            x = p.x; y=p.y;
            hasCollide = false;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x+6,y+6,cellWidth-12,cellWidth-12);
    }
     public void setHasCollide(Boolean b){
        hasCollide = b;
     }
}

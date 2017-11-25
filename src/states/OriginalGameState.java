package states;

import entities.Entity;
import entities.Snake;
import main.DisplayManager;
import main.InputManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OriginalGameState extends State {

    private final double cellWidth;
    private Logger logger;
    private final int cellNumber = 20 ;
    Canvas canvas;

    public OriginalGameState(){
        logger = Logger.getLogger(getClass().getName());
        canvas = DisplayManager.getInstance().getCanvas();
        cellWidth = canvas.getWidth()/cellNumber;

        if((cellWidth % 1) != 0){
            logger.severe("BOP");
        }

        logger = Logger.getLogger(getClass().getName());
        addEntity(new Snake(0,0,(int)cellWidth));
    }

    @Override
    public void init() {
        logger.log(Level.INFO," Iniciando Mappeo");
        InputManager input = InputManager.getInstance();
        input.addMapping("UP", KeyEvent.VK_UP);
        input.addMapping("DOWN", KeyEvent.VK_DOWN);
        input.addMapping("RIGHT", KeyEvent.VK_RIGHT);
        input.addMapping("LEFT", KeyEvent.VK_LEFT);


        super.init();
    }
    @Override
    public void render(Graphics g){
        drawGrid(g);
        super.render(g);

    }

    private void drawGrid(Graphics g) {
        for (int i = cellNumber-1; i > 0; i--) {
            int y =  (i*(int)cellWidth);
            g.drawLine(0,y,canvas.getWidth(),y);

        }
        for (int i = cellNumber-1; i > 0; i--) {
            int x =  (i*(int)cellWidth);
            g.drawLine(x,0,x,canvas.getHeight());
        }
        System.out.println("Cellnumber:" + cellNumber+ "cellWidth:" + cellWidth
        + "getwidth:" + canvas.getWidth() + "getheight:" + canvas.getHeight());

    }
}

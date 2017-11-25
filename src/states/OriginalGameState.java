package states;

import entities.Entity;
import entities.Food;
import entities.Snake;
import main.DisplayManager;
import main.InputManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OriginalGameState extends State {

    private static double cellWidth = 0.0;
    private Food food;
    private Snake snake;
    private Logger logger;
    private static final int cellNumber = 20 ;
    Canvas canvas;

    public OriginalGameState(){
        logger = Logger.getLogger(getClass().getName());
        canvas = DisplayManager.getInstance().getCanvas();
        cellWidth = canvas.getWidth()/cellNumber;

        if((cellWidth % 1) != 0){
            logger.severe("BOP");
        }

        logger = Logger.getLogger(getClass().getName());
        snake = new Snake(0,0,(int)cellWidth);
        addEntity(snake);
        Point p = getRandomPosition();
        food = new Food(p.x,p.y,(int)cellWidth);
        addEntity(food);
    }

    @Override
    public void init() {
        canvas.setBackground(new Color(225,225,225));
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

    @Override
    public void update(){
        checkCollision();
        super.update();
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

    public static Point getRandomPosition(){
        int xaux = ((int) (Math.random() * cellNumber));
        int yaux = ((int) (Math.random() * cellNumber));
        return new Point(xaux*(int)cellWidth,yaux*(int)cellWidth);
    }

    public void checkCollision(){
        if(snake.getHeadPosition().x == food.x && snake.getHeadPosition().y == food.y){
            snake.setGrow(true);
            food.setHasCollide(true);
        }
    }

}

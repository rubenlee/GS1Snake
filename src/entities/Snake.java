package entities;

import main.Application;
import main.DisplayManager;
import main.InputManager;

import java.awt.*;
import java.util.LinkedList;
import java.util.logging.Logger;

public class Snake extends Entity {
    private Logger logger;
    public int cellWidth;
    public boolean isMoving;
    public Color color;
    private InputManager input;
    private String direction;
    private Boolean isGrowing;

    private double freq;

    private LinkedList<Point> queue;
    private double updateCounter;

    public Snake(int x, int y,int cellWidth) {
        super(x, y);
        logger = Logger.getLogger(getClass().getName());
        this.cellWidth=cellWidth;
    }

    @Override
    public void init(){

        freq =  Application.amountOfTicks*2;
        updateCounter = 0;

        isGrowing = false;
        queue = new LinkedList<>();
        queue.addFirst(new Point(x,y));
        queue.addLast(new Point(x-cellWidth,y));
        queue.addLast(new Point(x-2*cellWidth,y));
        direction ="RIGHT";
        color = Color.RED;
        input = InputManager.getInstance();
        isMoving = true;
    }
    @Override
    public void update() {
        getInput(); //sets direction
        updateCounter++;
        if(updateCounter>freq) {
            updateCounter = 0;
            move();
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        for (Point p: queue) {
            g.fillRect((int)p.getX()+1,(int)p.getY()+1,cellWidth-1,cellWidth-1);
        }

    }

    public void setGrow(Boolean b){
        isGrowing = b;
    }

    private void move() {
        Point p = queue.get(0);
        Point newP = p;
        if(!isMoving) return;
        switch(direction){
            case "LEFT":
                newP = new Point((int)p.getX() - cellWidth,(int) p.getY());
                break;
            case "RIGHT":
                newP = new Point((int)p.getX() + cellWidth,(int) p.getY());
                break;
            case "UP":
                newP = new Point((int)p.getX(),(int) p.getY() - cellWidth);
                break;
            case "DOWN":
                newP = new Point((int)p.getX(),(int) p.getY() + cellWidth);
                break;
            default:

        }
        if (newP == p) {
            logger.warning("Snake not moving");
            return;
        }
        queue.addFirst(newP);
        if(isGrowing) {
            isGrowing = false;
            return;
        }
        queue.removeLast();
    }

    private void getInput() {
        if(input.isPressed("LEFT")){
            setDirection("LEFT");
        }
        if(input.isPressed("RIGHT")){
            setDirection("RIGHT");
        }
        if(input.isPressed("UP")){
            setDirection("UP");
        }
        if(input.isPressed("DOWN")){
            setDirection("DOWN");
        }
    }

    private void setDirection(String st) {
        direction = st;
    }

    private void resetSnake() {
        init();
    }






}

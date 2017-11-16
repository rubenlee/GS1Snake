package main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application implements Runnable {
    private Thread thread;
    private Boolean isRunning;
    private Logger logger;
    private Canvas canvas;
    private StateManager stateManager;
    public Application(){
        stateManager = StateManager.getInstance();
        canvas = DisplayManager.getInstance().getCanvas();
        Logger.getGlobal().log(Level.INFO," Aplication Running");//ejemplo a borrar de uso global del logger
    }
    public void run() {
        logger.log(Level.INFO," Aplication Running");
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 100000000 / amountOfTicks;

        double delta = 0;
        int updates = 0;
        int frames =0;
        long timer =System.currentTimeMillis();
        while(isRunning){
            long now = System.nanoTime();
            delta += (double)(now-lastTime) / (long)ns;
            lastTime=now;

            if(delta>=1){
                stateManager.update();
                updates++;
                delta--;
            }
            render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 100;
                logger.log(Level.INFO,updates + " Ticks, Fps " + frames);
                updates=0;
                frames=0;
            }
        }
        stop();
    }

    private void start(){
        logger = Logger.getLogger(getClass().getName());
        thread = new Thread(this);
        isRunning=true;
        thread.start();
    }
    public void stop(){
        try {
            thread.join();
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE," Thread Closing Error", e);
            e.printStackTrace();
        }
        System.exit(1);
    }

    private void render(){


        BufferStrategy bs = canvas.getBufferStrategy();
        if(bs==null){
            canvas.createBufferStrategy(2);
            bs = canvas.getBufferStrategy();
            logger.log(Level.WARNING," No existe BufferStrategy");
        }
        Graphics g = bs.getDrawGraphics();
        g.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        stateManager.render(g);
        bs.show();
        g.dispose();
    }

    public static void main (String [ ] args) {
        Application app = new Application();
        app.start();

    }

}


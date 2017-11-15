import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application implements Runnable {
    private Thread thread;
    private Boolean isRunning;
    private Logger logger;
    public void run() {
        StateManager stateManager = StateManager.getInstance();
        Canvas canvas = DisplayManager.getInstance().getCanvas();
        Logger.getGlobal().log(Level.INFO," Aplication Running");//ejemplo a borrar de uso global del logger
        logger.log(Level.INFO," Aplication Running");
        while(isRunning){
            stateManager.update();
            BufferStrategy bs = canvas.getBufferStrategy();
            if(bs==null){
                canvas.createBufferStrategy(3);
                bs = canvas.getBufferStrategy();
                logger.log(Level.WARNING," No existe BufferStrategy");
            }
            Graphics g = bs.getDrawGraphics();
            g.clearRect(0,0,300,300);
            stateManager.render(g);
            bs.show();
            g.dispose();

        }
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
    }
    public static void main (String [ ] args) {
        Application app = new Application();
        app.start();

    }

}

